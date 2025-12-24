package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);

    User getUserById(Long userId);

    List<User> getAllUsers();
}
