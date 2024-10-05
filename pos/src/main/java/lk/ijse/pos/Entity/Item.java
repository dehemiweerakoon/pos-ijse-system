package lk.ijse.pos.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public Item(Long id, String name, Double price, ItemCategory itemCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemCategory = itemCategory;
    }

    public Item() {
    }
}
