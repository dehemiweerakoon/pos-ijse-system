package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.SalesTransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTransactionItemRepository extends JpaRepository<SalesTransactionItem,Long> {
}
