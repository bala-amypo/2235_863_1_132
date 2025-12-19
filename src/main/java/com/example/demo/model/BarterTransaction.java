package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BarterTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private SkillMatch matchRecord;

    private String notes;
    private LocalDateTime completedAt;

    public BarterTransaction() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SkillMatch getMatchRecord() { return matchRecord; }
    public void setMatchRecord(SkillMatch matchRecord) { this.matchRecord = matchRecord; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}