package lk.ijse.pos.Controller;


import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItem());
    }
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        return new ResponseEntity<Item>(itemService.getItemById(id),HttpStatus.OK);
    }
    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        return new ResponseEntity<Item>(itemService.createItem(item),HttpStatus.CREATED);
    }
    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,@RequestBody Item item){
        return  new ResponseEntity<Item>(itemService.updateItem(id,item),HttpStatus.OK);
    }
    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
       return ResponseEntity.status(HttpStatus.OK).body("Item Deleted");
    }
    @GetMapping("/item/category/{id}")
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body( itemService.getItemByCategory(id));
    }
}