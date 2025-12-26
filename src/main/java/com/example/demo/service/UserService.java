package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    String login(AuthRequest request);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
