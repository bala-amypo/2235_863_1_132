package com.example.barter.controller;

import com.example.barter.dto.AuthRequest;
import com.example.barter.dto.AuthResponse;
import com.example.barter.model.User;
import com.example.barter.security.JwtUtil;
import com.example.barter.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
