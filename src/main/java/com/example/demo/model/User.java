package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String role;
    private int skillLevel;

    // Constructors
    public User() {}
    
    public User(String username, String role, int skillLevel) {
        this.username = username;
        this.role = role;
        this.skillLevel = skillLevel;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getSkillLevel() { return skillLevel; }
    public void setSkillLevel(int skillLevel) { this.skillLevel = skillLevel; }
}
