package com.example.server.service;

import com.example.server.dto.CartItemRequest;
import com.example.server.model.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(CartItemRequest request);
    List<Cart> getAllCarts();
    void deleteByProductId(Long id);
}
