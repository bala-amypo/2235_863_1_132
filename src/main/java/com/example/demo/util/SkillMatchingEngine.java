package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.SkillMatch;

import java.util.ArrayList;
import java.util.List;

public class SkillMatchingEngine {

    /**
     * Match skill offers with skill requests based on skill name and experience level.
     *
     * @param offers   List of SkillOffer
     * @param requests List of SkillRequest
     * @return List of SkillMatch with match scores
     */
    public static List<SkillMatch> matchSkills(List<SkillOffer> offers, List<SkillRequest> requests) {
        List<SkillMatch> matches = new ArrayList<>();

        for (SkillOffer offer : offers) {
            for (SkillRequest request : requests) {
                if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
                    double score = calculateScore(offer, request);
                    SkillMatch match = new SkillMatch();
                    match.setOffer(offer);
                    match.setRequest(request);
                    match.setMatchScore(score);
                    matches.add(match);
                }
            }
        }

        return matches;
    }

    /**
     * Calculate a simple match score based on experience and required levels.
     *
     * @param offer   SkillOffer
     * @param request SkillRequest
     * @return match score (0-100)
     */
    private static double calculateScore(SkillOffer offer, SkillRequest request) {
        int offerLevel = offer.getExperienceLevel();
        int requestLevel = request.getRequiredLevel();

        // Basic scoring: 100 if exact match, less if lower
        double score = 0;
        if (offerLevel >= requestLevel) {
            score = 100;
        } else {
            score = ((double) offerLevel / requestLevel) * 100;
        }

        return score;
    }
}
