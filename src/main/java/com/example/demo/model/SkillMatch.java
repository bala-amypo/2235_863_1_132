package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile userA;

    @ManyToOne
    private UserProfile userB;

    @ManyToOne
    private SkillCategory skillOfferedByA;

    @ManyToOne
    private SkillCategory skillOfferedByB;

    private LocalDateTime matchedAt = LocalDateTime.now();
    private String status = "PENDING"; // Rule: Defaults to PENDING

    public SkillMatch() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserProfile getUserA() { return userA; }
    public void setUserA(UserProfile userA) { this.userA = userA; }
    public UserProfile getUserB() { return userB; }
    public void setUserB(UserProfile userB) { this.userB = userB; }
    public SkillCategory getSkillOfferedByA() { return skillOfferedByA; }
    public void setSkillOfferedByA(SkillCategory s) { this.skillOfferedByA = s; }
    public SkillCategory getSkillOfferedByB() { return skillOfferedByB; }
    public void setSkillOfferedByB(SkillCategory s) { this.skillOfferedByB = s; }
    public LocalDateTime getMatchedAt() { return matchedAt; }
    public void setMatchedAt(LocalDateTime matchedAt) { this.matchedAt = matchedAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}