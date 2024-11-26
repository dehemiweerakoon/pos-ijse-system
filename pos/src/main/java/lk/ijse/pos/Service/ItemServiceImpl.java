package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements  ItemService {
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no such element"));
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item updateItem(Long id,Item item) {
         Item item1 = getItemById(id);
         item1.setName(item.getName());
         item1.setPrice(item.getPrice());
         item1.setItemCategory(item.getItemCategory());

        return itemRepository.save(item1);
    }

    @Override
    public List<Item> getItemByCategory(Long category) {
        return itemRepository.findByItemCategoryId(category);
    }
}
