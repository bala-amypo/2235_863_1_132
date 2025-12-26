package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> get(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> list() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<AppUser> updateRating(
            @PathVariable Long id,
            @RequestParam double rating
    ) {
        return ResponseEntity.ok(userService.updateRating(id, rating));
    }
}
