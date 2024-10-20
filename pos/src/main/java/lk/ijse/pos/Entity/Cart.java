package lk.ijse.pos.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "double default 0")
    private Double totalAmount=0.0;
    public Cart(){

    }
    public Cart(Long id){
        this.id=id;
    }
}
