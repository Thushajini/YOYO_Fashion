package com.example.eCommerce.service.impl;

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
    private UserRepository userRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Cart getCartByUser(String username) {
        return cartRepository.findByuserUsername(username)
                .orElseGet(() -> createCartForUser(username));
    }

    @Override
    public Cart addToCart(String username, Long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        Cart cart = getCartByUser(username);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            int newquantity = item.getQuantity() + quantity;


            if (product.getStock() < newquantity) {
                throw new RuntimeException("Not enough stock for updated quantity");
            }
            item.setQuantity(newquantity);
        } else {
            CartItem item = CartItem.builder()
                    .cart(cart)
                    .product(product)
                    .quantity(quantity)
                    .build();

            cart.getItems().add(item);



        }
        return cartRepository.save(cart);

    }

    public Cart removeFromCart(String username,Long productId){
        Cart cart = getCartByUser(username);

        cart.getItems().removeIf(item-> item.getProduct().getProductId().equals(productId));
        return cartRepository.save(cart);
    }


    private Cart createCartForUser(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);

}
}
