package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillCategory skill;

    private String experienceLevel; // Beginner, Intermediate, Expert
    private Integer availableHoursPerWeek;
    private Boolean active = true;

    public SkillOffer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
    public SkillCategory getSkill() { return skill; }
    public void setSkill(SkillCategory skill) { this.skill = skill; }
    public String getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }
    public Integer getAvailableHoursPerWeek() { return availableHoursPerWeek; }
    public void setAvailableHoursPerWeek(Integer hours) { this.availableHoursPerWeek = hours; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}