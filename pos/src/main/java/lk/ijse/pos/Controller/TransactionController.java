package lk.ijse.pos.Controller;

import lk.ijse.pos.Entity.SalesTransaction;
import lk.ijse.pos.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/buy/{cartId}")
    public ResponseEntity<SalesTransaction> buyItems(@PathVariable Long cartId){

        return ResponseEntity.status(HttpStatus.OK).body(transactionService.completeTransaction(cartId));
    }
}
