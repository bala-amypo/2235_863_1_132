package com.example.demo.model;

import java.time.LocalDateTime;

public class BarterTransaction {

    private Long id;
    private SkillMatch match;
    private User fromUser;
    private User toUser;
    private String remarks;
    private LocalDateTime createdAt;

    public BarterTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillMatch getMatch() {
        return match;
    }

    public void setMatch(SkillMatch match) {
        this.match = match;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
