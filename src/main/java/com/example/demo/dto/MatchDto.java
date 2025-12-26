package com.example.barter.dto;

import com.example.barter.model.SkillOffer;
import com.example.barter.model.SkillRequest;

public class MatchDto {

    private SkillOffer offer;
    private SkillRequest request;
    private double matchScore;

    public MatchDto() {}

    public MatchDto(SkillOffer offer, SkillRequest request, double matchScore) {
        this.offer = offer;
        this.request = request;
        this.matchScore = matchScore;
    }

    public SkillOffer getOffer() {
        return offer;
    }

    public void setOffer(SkillOffer offer) {
        this.offer = offer;
    }

    public SkillRequest getRequest() {
        return request;
    }

    public void setRequest(SkillRequest request) {
        this.request = request;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }
}
