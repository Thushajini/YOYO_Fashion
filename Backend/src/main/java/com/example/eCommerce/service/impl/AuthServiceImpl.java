package com.example.eCommerce.service.impl;

import com.example.eCommerce.dto.LoginRequest;
import com.example.eCommerce.dto.RegisterRequest;
import com.example.eCommerce.model.User;
import com.example.eCommerce.repository.UserRepository;
import com.example.eCommerce.service.AuthService;

import com.example.eCommerce.util.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {
private UserRepository userRepository;
private PasswordEncoder passwordEncoder;
private JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        String Regemail = registerRequest.getEmail();
        String Regusername = registerRequest.getUsername();
        String Regpassword = registerRequest.getPassword();
        if(userRepository.findByUsername(Regemail).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .email(Regemail)
                .username(Regusername)
                .password(Regpassword)
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
        return "User registered successfully";


    }

    @Override
    public String login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));


        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new IllegalArgumentException("Invalid username or password");
        }
        return jwtUtil.generateToken(user.getUsername());

    }
}
