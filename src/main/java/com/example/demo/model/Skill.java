package com.example.demo.model;

public class SkillMatch {

    private Long id;
    private User userA;
    private User userB;
    private SkillCategory skillOfferedByA;
    private SkillCategory skillOfferedByB;
    private String status = "PENDING";

    public SkillMatch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserA() {
        return userA;
    }

    public void setUserA(User userA) {
        this.userA = userA;
    }

    public User getUserB() {
        return userB;
    }

    public void setUserB(User userB) {
        this.userB = userB;
    }

    public SkillCategory getSkillOfferedByA() {
        return skillOfferedByA;
    }

    public void setSkillOfferedByA(SkillCategory skillOfferedByA) {
        this.skillOfferedByA = skillOfferedByA;
    }

    public SkillCategory getSkillOfferedByB() {
        return skillOfferedByB;
    }

    public void setSkillOfferedByB(SkillCategory skillOfferedByB) {
        this.skillOfferedByB = skillOfferedByB;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
