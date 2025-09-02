package com.example.server.service.impl;

import com.example.server.dto.CartItemRequest;
import com.example.server.model.Cart;
import com.example.server.model.Product;
import com.example.server.repository.CartRepository;
import com.example.server.repository.ProductRepository;
import com.example.server.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {



    private ProductRepository productRepository;
    private CartRepository cartRepository;
    public CartServiceImpl(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart addToCart( CartItemRequest request) {
        Product product =productRepository.findById(request.getProductId())
                .orElseThrow(()->new RuntimeException("Product not found") );

        Cart cartItem =new Cart();
        cartItem.setProduct(product);
        cartItem.setQuantity(request.getQuantity());
        return cartRepository.save(cartItem);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteByProductId(Long id) {
        List<Cart> cartItem = cartRepository.findByProduct_ProductId(id);
        if(cartItem.isEmpty())
        {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cart items found for productId: " + id);
        }
         cartRepository.deleteAll(cartItem);
    }
}
