package com.example.eCommerce.controller;

import com.example.eCommerce.dto.AddToCartDto;
import com.example.eCommerce.dto.RemoveFromCartDto;
import com.example.eCommerce.model.Cart;
import com.example.eCommerce.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Cart> getCart(){
        String username = getCurrentUsername();
        return  ResponseEntity.ok(cartService.getCartByUser(username));
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@PathVariable String username, @RequestBody AddToCartDto addCartDto){
        return ResponseEntity.ok(cartService.addToCart(username, addCartDto.getProductId(), addCartDto.getQuantity()));

    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Cart> removeFromCart(@PathVariable String username, @RequestBody RemoveFromCartDto removeCartDto){
        return ResponseEntity.ok(cartService.removeFromCart(username, removeCartDto.getProductId()));
    }

    private String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
