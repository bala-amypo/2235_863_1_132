package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_offers")
public class SkillOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private SkillCategory category;

    private String skillName;

    private int experienceLevel;

    public SkillOffer() {}

    public SkillOffer(User user, SkillCategory category, String skillName, int experienceLevel) {
        this.user = user;
        this.category = category;
        this.skillName = skillName;
        this.experienceLevel = experienceLevel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public SkillCategory getCategory() { return category; }
    public void setCategory(SkillCategory category) { this.category = category; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public int getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(int experienceLevel) { this.experienceLevel = experienceLevel; }
}
