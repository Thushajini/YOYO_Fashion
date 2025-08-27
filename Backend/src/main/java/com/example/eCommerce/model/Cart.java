package com.example.eCommerce.model;


import jakarta.persistence.*;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Carts")



public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private String username;


    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();
}
