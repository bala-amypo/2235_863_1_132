package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "skill_matches")
public class SkillMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "offer_id")
    private SkillOffer offer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id")
    private SkillRequest request;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matched_by")
    private User matchedBy;

    @Column(nullable = false)
    private String matchStatus = "PENDING";

    @Column(nullable = false)
    private Double matchScore = 0.0;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "match")
    private List<demoTransaction> transactions;

    public SkillMatch() {}

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.matchStatus == null) this.matchStatus = "PENDING";
        if (this.matchScore == null) this.matchScore = 0.0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }

    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }

    public User getMatchedBy() { return matchedBy; }
    public void setMatchedBy(User matchedBy) { this.matchedBy = matchedBy; }

    public String getMatchStatus() { return matchStatus; }
    public void setMatchStatus(String matchStatus) { this.matchStatus = matchStatus; }

    public Double getMatchScore() { return matchScore; }
    public void setMatchScore(Double matchScore) { this.matchScore = matchScore; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
