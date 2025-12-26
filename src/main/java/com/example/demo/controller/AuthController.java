package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/token")
    public String generateToken(@RequestParam String username) {
        return jwtUtil.generateToken(username);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam String token, @RequestParam String username) {
        boolean valid = jwtUtil.validateToken(token, username);
        return valid ? "Valid Token" : "Invalid Token";
    }
}
