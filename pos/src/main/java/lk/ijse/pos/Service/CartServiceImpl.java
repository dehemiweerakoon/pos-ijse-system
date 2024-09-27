package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Cart;
import lk.ijse.pos.Entity.CartItem;
import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Repository.CartItemRepository;
import lk.ijse.pos.Repository.CartRepository;
import lk.ijse.pos.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public Cart addItemToCart(Long cartId, Long itemId, int qty) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        Item item = itemRepository.findById(itemId).orElseThrow(()-> new NoSuchElementException("No such Item Exist"));

        CartItem cartItem = new CartItem();

        cartItem.setItem(item);
        cartItem.setPrice(item.getPrice());
        cartItem.setQuantity(qty);

        cart.getCartItems().add(cartItem);
        cart.setTotalAmount(cart.getTotalAmount()+(item.getPrice()*qty));


        cartItemRepository.save(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no such cart with id"));
    }
}
