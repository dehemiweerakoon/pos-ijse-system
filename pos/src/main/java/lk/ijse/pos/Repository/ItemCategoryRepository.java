package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
}
