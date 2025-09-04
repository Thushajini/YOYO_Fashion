package com.example.server.service;

import com.example.server.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product createProduct(Product product);
}
