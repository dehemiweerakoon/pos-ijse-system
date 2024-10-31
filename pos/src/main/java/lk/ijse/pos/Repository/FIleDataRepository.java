package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.FileData;
import lk.ijse.pos.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FIleDataRepository extends JpaRepository<FileData, Integer> {
    Optional<FileData> findByName(String name);
}
