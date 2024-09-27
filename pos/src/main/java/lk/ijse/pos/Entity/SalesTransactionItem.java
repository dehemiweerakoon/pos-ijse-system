package lk.ijse.pos.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SalesTransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;

    private int quantity;
    private Double price;

}
