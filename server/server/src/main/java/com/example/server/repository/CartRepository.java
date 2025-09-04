package com.example.server.repository;

import com.example.server.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByProduct_ProductId(Long productId);
    void deleteByProduct_ProductId(Long productId);
}
