package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_matches")
public class SkillMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SkillOffer offer;

    @ManyToOne
    private SkillRequest request;

    private double matchScore;

    public SkillMatch() {}

    public SkillMatch(SkillOffer offer, SkillRequest request, double matchScore) {
        this.offer = offer;
        this.request = request;
        this.matchScore = matchScore;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }

    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }
}
