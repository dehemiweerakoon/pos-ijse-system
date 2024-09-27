package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.SalesTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction,Long> {
}
