package com.example.demo.util;

import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;

public class SkillMatchingEngine {

    /**
     * Calculates match score between a SkillOffer and SkillRequest.
     * Score range: 0.0 – 100.0
     */
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {

        if (offer == null || request == null) {
            return 0.0;
        }

        double score = 0.0;

        // Skill name similarity
        if (offer.getSkillName() != null && request.getSkillName() != null) {
            if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
                score += 50.0;
            }
        }

        // Category match
        if (offer.getCategory() != null && request.getCategory() != null) {
            if (offer.getCategory().getId().equals(request.getCategory().getId())) {
                score += 30.0;
            }
        }

        // Experience / required level alignment
        if (offer.getExperienceLevel() != null && request.getRequiredLevel() != null) {
            if (offer.getExperienceLevel().equalsIgnoreCase(request.getRequiredLevel())) {
                score += 20.0;
            }
        }

        // Cap score at 100
        return Math.min(score, 100.0);
    }

    /**
     * Applies score to SkillMatch entity.
     */
    public SkillMatch applyScore(SkillMatch match) {
        double score = calculateMatchScore(match.getOffer(), match.getRequest());
        match.setMatchScore(score);
        return match;
    }
}
