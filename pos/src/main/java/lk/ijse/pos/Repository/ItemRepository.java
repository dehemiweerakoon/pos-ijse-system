package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByItemCategoryId(Long categoryId);
}
