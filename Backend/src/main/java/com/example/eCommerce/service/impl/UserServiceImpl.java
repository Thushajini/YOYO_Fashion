package com.example.eCommerce.service.impl;

import com.example.eCommerce.model.User;
import com.example.eCommerce.repository.UserRepository;
import com.example.eCommerce.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
     if(!userRepository.existsById(userId)){
         throw new RuntimeException(("user not found"));
     }
     userRepository.deleteById(userId);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
