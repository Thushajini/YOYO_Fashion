package com.example.eCommerce.service;

import com.example.eCommerce.dto.AddToCartDto;
import com.example.eCommerce.model.Cart;

public interface CartService {
    Cart getCartByUser(String username);
    Cart addToCart(String username, AddToCartDto request);
    Cart removeFromCart(String username,Long productId);
}
