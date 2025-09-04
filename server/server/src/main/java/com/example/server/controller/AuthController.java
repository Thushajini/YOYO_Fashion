package com.example.server.controller;

import com.example.server.dto.LoginRequest;
import com.example.server.dto.RegisterRequest;
import com.example.server.entity.User;
import com.example.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest){

            User newUser = userService.Register(registerRequest);
            return ResponseEntity.ok(newUser);


    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest){
        try {
            String jwt = userService.Login(loginRequest);
            return ResponseEntity.ok(jwt);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
