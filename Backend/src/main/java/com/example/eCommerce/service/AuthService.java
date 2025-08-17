package com.example.eCommerce.service;

import com.example.eCommerce.dto.LoginRequest;
import com.example.eCommerce.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthService {
    String  register(RegisterRequest registerRequest);
String login(LoginRequest loginRequest);
}
