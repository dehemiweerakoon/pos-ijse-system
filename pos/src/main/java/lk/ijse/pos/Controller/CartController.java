package lk.ijse.pos.Controller;

import lk.ijse.pos.Entity.Cart;
import lk.ijse.pos.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/addItem/{itemId}/{qty}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId,@PathVariable Long itemId,@PathVariable int qty){
        Cart updateCart = cartService.addItemToCart(cartId,itemId,qty);
        return ResponseEntity.status(HttpStatus.OK).body(updateCart);
    }
    @GetMapping("/{cartId}/cart")
    public  ResponseEntity<Cart> getCart(@PathVariable Long cartId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cartService.getCart(cartId));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.OK).body(new Cart());
        }
    }
}
