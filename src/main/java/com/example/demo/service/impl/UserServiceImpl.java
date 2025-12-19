package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile createUserProfile(UserProfile profile) {
        // Implementation for creating profile
        return null; 
    }

    @Override
    public UserProfile updateUserProfile(Long id, UserProfile profile) {
        // Implementation for updating profile
        return null;
    }

    @Override
    public UserProfile getUserProfile(Long id) {
        // Implementation for fetching profile
        return null;
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        // Implementation for listing profiles
        return null;
    }

    @Override
    public void deactivateUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // Assuming there is an 'active' field in your User model
        // user.setActive(false); 
        userRepository.save(user);
    }
}