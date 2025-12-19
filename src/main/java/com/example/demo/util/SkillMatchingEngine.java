package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {
    
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        double score = 0.0;
        
        // Basic skill name matching
        if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
            score += 50.0;
        }
        
        // Experience level matching
        if (offer.getExperienceLevel().equals(request.getRequiredLevel())) {
            score += 30.0;
        }
        
        // Category matching
        if (offer.getSkillCategory().getId().equals(request.getSkillCategory().getId())) {
            score += 20.0;
        }
        
        return Math.min(score, 100.0);
    }
}