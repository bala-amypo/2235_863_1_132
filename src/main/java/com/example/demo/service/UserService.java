package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import java.util.List;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    UserProfile createUserProfile(UserProfile profile);
    UserProfile updateUserProfile(Long id, UserProfile profile);
    UserProfile getUserProfile(Long id);
    List<UserProfile> getAllProfiles();
    void deactivateUser(Long id);
}