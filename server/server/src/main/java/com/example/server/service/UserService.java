package com.example.server.service;

import com.example.server.dto.LoginRequest;
import com.example.server.dto.RegisterRequest;
import com.example.server.entity.User;

public interface UserService {
    User Register(RegisterRequest registerRequest);
    String Login(LoginRequest loginRequest);


}
