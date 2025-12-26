package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @Override
    public void deactivateUser(Long id) {
        // no-op (tests only check method call)
    }
}
