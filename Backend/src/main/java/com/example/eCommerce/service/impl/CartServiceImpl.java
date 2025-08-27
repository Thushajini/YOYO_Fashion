package com.example.eCommerce.service.impl;

import com.example.eCommerce.dto.AddToCartDto;
import com.example.eCommerce.model.Cart;
import com.example.eCommerce.model.CartItem;
import com.example.eCommerce.model.Product;
import com.example.eCommerce.model.User;
import com.example.eCommerce.repository.CartRepository;
import com.example.eCommerce.repository.ProductRepository;
import com.example.eCommerce.repository.UserRepository;
import com.example.eCommerce.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;


    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;

    }

    @Override
    public Cart getCartByUser(String username) {
        return cartRepository.findByUsername(username)
                .orElseGet(() -> createCartForUser(username));
    }

    @Override
    public Cart addToCart(String username, AddToCartDto request) {

        Cart cart = cartRepository.findByUsername(username)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUsername(username);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(product.getProductId()))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + request.getQuantity());

        } else {
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(request.getQuantity());
            newItem.setCart(cart);
            cart.getItems().add(newItem);

        }

        return cartRepository.save(cart);

}


    public Cart removeFromCart(String username,Long productId){
        Cart cart = getCartByUser(username);

        cart.getItems().removeIf(item-> item.getProduct().getProductId().equals(productId));
        return cartRepository.save(cart);
    }

    private Cart createCartForUser(String username){

        Cart cart = new Cart();
        cart.setUsername(username);
        return cartRepository.save(cart);

    }

}
