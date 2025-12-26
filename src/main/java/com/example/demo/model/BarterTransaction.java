package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "barter_transactions")
public class BarterTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "match_id")
    private SkillMatch match;

    private String status = "IN_PROGRESS";

    private Integer offererRating;
    private Integer requesterRating;

    private LocalDateTime completedAt;

    public BarterTransaction() {
    }

    public BarterTransaction(SkillMatch match) {
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public SkillMatch getMatch() {
        return match;
    }

    public String getStatus() {
        return status;
    }

    public Integer getOffererRating() {
        return offererRating;
    }

    public Integer getRequesterRating() {
        return requesterRating;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatch(SkillMatch match) {
        this.match = match;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOffererRating(Integer offererRating) {
        this.offererRating = offererRating;
    }

    public void setRequesterRating(Integer requesterRating) {
        this.requesterRating = requesterRating;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
