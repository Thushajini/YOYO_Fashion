package com.example.eCommerce.service;

import com.example.eCommerce.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long userId);

    void saveUser(User user);
}
