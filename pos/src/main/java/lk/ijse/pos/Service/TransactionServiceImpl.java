package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.*;
import lk.ijse.pos.Repository.CartItemRepository;
import lk.ijse.pos.Repository.CartRepository;
import lk.ijse.pos.Repository.SalesTransactionRepository;
import lk.ijse.pos.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionServiceImpl implements  TransactionService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    SalesTransactionRepository salesTransactionRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public SalesTransaction completeTransaction(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new NoSuchElementException("There is no such element"));
        SalesTransaction salesTransaction = new SalesTransaction();
        salesTransaction.setTransactionDate(LocalDateTime.now());
        salesTransaction.setTotalAmount(cart.getTotalAmount());

        List<SalesTransactionItem> transactionItems = new ArrayList<>();

        for(CartItem cartItem: cart.getCartItems()){
            Stock stock = stockRepository.findByItemId(cartItem.getItem().getId()).orElseThrow(()-> new NoSuchElementException("no element"));
            if(stock.getQuantity()<cartItem.getQuantity()){
                throw  new RuntimeException("Insufficient stock for item"+cartItem.getItem().getName());
            }
            stock.setQuantity(stock.getQuantity()-cartItem.getQuantity());
            stockRepository.save(stock);
            //add to transaction items

            SalesTransactionItem salesTransactionItem = new SalesTransactionItem();
            salesTransactionItem.setItem(cartItem.getItem());
            salesTransactionItem.setQuantity(cartItem.getQuantity());
            salesTransactionItem.setPrice(cartItem.getPrice());

            transactionItems.add(salesTransactionItem);
        }
        salesTransaction.setItems(transactionItems);
        salesTransactionRepository.save(salesTransaction);
        // clear cart
        cartItemRepository.deleteAll(cart.getCartItems());
        cartRepository.delete(cart);

        return salesTransaction;
    }
}
