package com.example.barter.util;

import com.example.barter.model.SkillOffer;
import com.example.barter.model.SkillRequest;
import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {
    
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        double score = 0.0;
        
        // Skill name similarity
        if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
            score += 50.0;
        }
        
        // Experience level matching
        if (offer.getExperienceLevel().equals(request.getRequiredLevel())) {
            score += 30.0;
        }
        
        // User rating bonus
        if (offer.getUser().getRating() >= 4.0) {
            score += 20.0;
        }
        
        return Math.min(score, 100.0);
    }
}