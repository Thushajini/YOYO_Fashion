package com.example.server.controller;

import com.example.server.dto.CartItemRequest;
import com.example.server.entity.Cart;
import com.example.server.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping ("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartItemRequest cartItemRequest){
      Cart cart = cartService.addToCart(cartItemRequest);
      return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }
@GetMapping
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
}

@DeleteMapping("/product/{id}")
    public  ResponseEntity<Void> removeItemFromCart(@PathVariable Long id){
       cartService.deleteByProductId(id);
    return ResponseEntity.noContent().build();
}


}
