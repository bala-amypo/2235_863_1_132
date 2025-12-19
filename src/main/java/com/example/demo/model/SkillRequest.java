package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillCategory skill;

    private String urgencyLevel; // Low, Medium, High
    private Boolean active = true;

    public SkillRequest() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
    public SkillCategory getSkill() { return skill; }
    public void setSkill(SkillCategory skill) { this.skill = skill; }
    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String level) { this.urgencyLevel = level; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}