package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    Cart addItemToCart(Long cartId,Long itemId,int qty);
    Cart getCart(Long id);
}
