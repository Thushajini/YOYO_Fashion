package com.example.server.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity

@Table(name ="Cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int quantity;



    public Cart(Long cartId, Product product, int quantity) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;

    }

    public Cart() {
    }

    public Cart(Product product, int quantity,User user) {
        this.product = product;
        this.quantity = quantity;


    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
