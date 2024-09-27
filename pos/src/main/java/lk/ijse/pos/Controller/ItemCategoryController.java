package lk.ijse.pos.Controller;

import lk.ijse.pos.Entity.ItemCategory;
import lk.ijse.pos.Service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ItemCategory>> getAllItemCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoryService.getAllCategory());
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<ItemCategory> getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoryService.getItemCategoryById(id));
    }
    @PostMapping("/categories")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory){
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoryService.createItemCategory(itemCategory));
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long id,@RequestBody ItemCategory itemCategory){
        return  ResponseEntity.status(HttpStatus.OK).body(itemCategoryService.updateItemCategory(id,itemCategory));
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteItemCategory(@PathVariable Long id){
        itemCategoryService.deleteItemCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("item is deleted ");
    }
}
