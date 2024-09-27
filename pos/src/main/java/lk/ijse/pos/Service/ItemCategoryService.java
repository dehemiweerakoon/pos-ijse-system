package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.ItemCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemCategoryService {

    List<ItemCategory> getAllCategory();
    ItemCategory getItemCategoryById(Long id);
    ItemCategory createItemCategory(ItemCategory itemCategory);
    void deleteItemCategory(Long id);
    ItemCategory updateItemCategory(Long id,ItemCategory itemCategory);
}
