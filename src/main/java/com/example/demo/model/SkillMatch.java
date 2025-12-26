package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_matches")
public class SkillMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private SkillRequest skillRequest;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private SkillOffer skillOffer;

    private String status = "MATCHED";

    public SkillMatch() {
    }

    public SkillMatch(SkillRequest skillRequest, SkillOffer skillOffer) {
        this.skillRequest = skillRequest;
        this.skillOffer = skillOffer;
    }

    public Long getId() {
        return id;
    }

    public SkillRequest getSkillRequest() {
        return skillRequest;
    }

    public SkillOffer getSkillOffer() {
        return skillOffer;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillRequest(SkillRequest skillRequest) {
        this.skillRequest = skillRequest;
    }

    public void setSkillOffer(SkillOffer skillOffer) {
        this.skillOffer = skillOffer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
