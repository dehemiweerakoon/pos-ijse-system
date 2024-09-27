package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getAllItem();
    Item getItemById(Long id);
    Item createItem(Item item);
   void deleteItem(Long id);
    Item updateItem(Long id,Item item);
}
