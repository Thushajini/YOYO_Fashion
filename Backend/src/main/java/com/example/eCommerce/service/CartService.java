package com.example.eCommerce.service;

import com.example.eCommerce.model.Cart;

public interface CartService {
    Cart getCartByUser(String username);
    Cart addToCart(String username,Long productId,int quantity);
    Cart removeFromCart(String username,Long productId);
}
