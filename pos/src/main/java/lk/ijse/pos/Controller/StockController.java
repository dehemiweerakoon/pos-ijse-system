package lk.ijse.pos.Controller;

import lk.ijse.pos.Entity.Stock;
import lk.ijse.pos.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getAllStock());
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockById(id));
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> createStock(@RequestBody  Stock stock){
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.createStock(stock));
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id,@RequestBody Stock stock){
        return ResponseEntity.status(HttpStatus.OK).body(stockService.updateStock(id,stock));
    }
    @DeleteMapping("/stock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
        return ResponseEntity.status(HttpStatus.OK).body("Stock is deleted");
    }
    @GetMapping("/stock/byItem/{id}")
    public ResponseEntity<Stock> getStockByItem(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(stockService.findByItemId(id));
    }
}
