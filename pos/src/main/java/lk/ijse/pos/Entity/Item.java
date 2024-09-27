package lk.ijse.pos.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory itemCategory;
}
