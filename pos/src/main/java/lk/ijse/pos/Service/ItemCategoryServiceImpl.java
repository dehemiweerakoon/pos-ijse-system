package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.ItemCategory;
import lk.ijse.pos.Repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategory() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id).orElseThrow(()->new NoSuchElementException("No such element exist"));
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public void deleteItemCategory(Long id) {
        itemCategoryRepository.deleteById(id);
    }

    @Override
    public ItemCategory updateItemCategory(Long id,ItemCategory itemCategory) {
        ItemCategory itemCategory1 = getItemCategoryById(id);
        itemCategory1.setName(itemCategory.getName());
        return itemCategoryRepository.save(itemCategory1);
    }
}
