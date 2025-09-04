package com.example.server.service.impl;

import com.example.server.dto.LoginRequest;
import com.example.server.dto.RegisterRequest;
import com.example.server.entity.User;
import com.example.server.repository.UserRepository;
import com.example.server.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User Register(RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }

        User newUser = new User();
               newUser.setEmail(registerRequest.getEmail());
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());
       return  userRepository.save(newUser);


    }

    @Override
    public String Login(LoginRequest loginRequest) {
        User user =userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new RuntimeException("Invalid email"));
//     if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//         throw new IllegalArgumentException("Invalid email or password");
//     }
     return "Login Successful";
    }
}
