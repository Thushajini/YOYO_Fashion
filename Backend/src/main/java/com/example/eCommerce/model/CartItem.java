package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="CartItems")
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
    private int quantity;

}
