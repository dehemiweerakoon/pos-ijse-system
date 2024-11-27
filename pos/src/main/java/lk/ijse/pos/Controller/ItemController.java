package lk.ijse.pos.Controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
@Tag(name = "Transactions")
public class ItemController {

    @Autowired
    ItemService itemService;


    @Operation(security = @SecurityRequirement(name = "basicAuth"))
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
@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Sample API", version = "v1"),
        security = @SecurityRequirement(name = "bearerAuth") // Link security scheme to API
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER // Specify token should be in the header
)
class DocsConfiguration {
}
