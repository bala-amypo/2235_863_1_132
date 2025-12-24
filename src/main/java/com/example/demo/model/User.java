package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String location;

    @Column(nullable = false)
    private String role = "USER";

    @Column(nullable = false)
    private Double rating = 0.0;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<SkillOffer> skillOffers;

    @OneToMany(mappedBy = "user")
    private List<SkillRequest> skillRequests;

    @OneToMany(mappedBy = "matchedBy")
    private List<SkillMatch> skillMatches;

    public User() {}

    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) this.role = "USER";
        if (this.rating == null) this.rating = 0.0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public List<SkillOffer> getSkillOffers() { return skillOffers; }
    public void setSkillOffers(List<SkillOffer> skillOffers) { this.skillOffers = skillOffers; }

    public List<SkillRequest> getSkillRequests() { return skillRequests; }
    public void setSkillRequests(List<SkillRequest> skillRequests) { this.skillRequests = skillRequests; }

    public List<SkillMatch> getSkillMatches() { return skillMatches; }
    public void setSkillMatches(List<SkillMatch> skillMatches) { this.skillMatches = skillMatches; }
}
