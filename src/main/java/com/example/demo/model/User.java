package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<SkillOffer> skillOffers;

    @OneToMany(mappedBy = "user")
    private Set<SkillRequest> skillRequests;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<SkillOffer> getSkillOffers() { return skillOffers; }
    public void setSkillOffers(Set<SkillOffer> skillOffers) { this.skillOffers = skillOffers; }
    public Set<SkillRequest> getSkillRequests() { return skillRequests; }
    public void setSkillRequests(Set<SkillRequest> skillRequests) { this.skillRequests = skillRequests; }
}
