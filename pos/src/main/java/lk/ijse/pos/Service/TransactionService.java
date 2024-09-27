package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.SalesTransaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    SalesTransaction completeTransaction(Long cartId);
}
