package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Cart;
import lk.ijse.pos.Entity.CartItem;
import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Repository.CartItemRepository;
import lk.ijse.pos.Repository.CartRepository;
import lk.ijse.pos.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Cart cart = cartRepository.findById(cartId).orElse(new Cart(cartId));
        Item item = itemRepository.findById(itemId).orElseThrow(()-> new NoSuchElementException("No such Item Exist"));

        List<CartItem> avail = cart.getCartItems();

        for (CartItem cartItem : avail) {
            if(cartItem.getItem().getId().equals(itemId)){
                 cartItem.setQuantity(cartItem.getQuantity() + qty);
                 cart.setTotalAmount(cart.getTotalAmount() + cartItem.getPrice());
                 cartItemRepository.save(cartItem);
                 return cartRepository.save(cart);
                 // added the cart items ....
            }
        }

        CartItem cartItem = new CartItem();

        cartItem.setItem(item);
        cartItem.setPrice(item.getPrice());
        cartItem.setQuantity(qty);

        cart.getCartItems().add(cartItem);
        cart.setTotalAmount(cart.getTotalAmount()+(item.getPrice()*qty));


        cartItemRepository.save(cartItem);
        return cartRepository.save(cart);
    }

    //  get cart with the property 
    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no such cart with id"));
    }

    @Override
    public Cart deleteItemFromCart(Long cartId, Long itemId, int qty) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new NoSuchElementException("No such Item Exist"));
        List<CartItem> avail = cart.getCartItems();
        for (CartItem cartItem : avail) {
           CartItem cartItem1= cartItemRepository.findById(cartItem.getId()).orElseThrow(()-> new NoSuchElementException("No such Item Exist"));
           if(cartItem1.getItem().getId().equals(itemId)){
               try{
                   cart.setTotalAmount(cart.getTotalAmount() - (cartItem.getItem().getPrice() * cartItem.getQuantity()));
                   avail.remove(cartItem); // Remove from the cart's list
                   cartItemRepository.deleteById(cartItem.getId());
               }catch (Exception e){
                   System.out.println("deleted error");
               }

               return null;
           }
        }
        return  null;
    }
}
