package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SkillMatchingEngine {

    public SkillMatchingEngine() {}

    /**
     * Logical check to see if two users have a mutual interest.
     * @param userAOffers Skills User A can provide
     * @param userARequests Skills User A wants
     * @param userBOffers Skills User B can provide
     * @param userBRequests Skills User B wants
     * @return boolean true if a cross-match exists
     */
    public boolean isMatch(List<SkillOffer> userAOffers, 
                           List<SkillRequest> userARequests, 
                           List<SkillOffer> userBOffers, 
                           List<SkillRequest> userBRequests) {
        
        boolean bHasWhatAWants = false;
        boolean aHasWhatBWants = false;

        // Check if User B offers any skill that User A requested
        for (SkillRequest reqA : userARequests) {
            for (SkillOffer offB : userBOffers) {
                if (reqA.getSkill().getId().equals(offB.getSkill().getId())) {
                    bHasWhatAWants = true;
                    break;
                }
            }
        }

        // Check if User A offers any skill that User B requested
        for (SkillRequest reqB : userBRequests) {
            for (SkillOffer offA : userAOffers) {
                if (reqB.getSkill().getId().equals(offA.getSkill().getId())) {
                    aHasWhatBWants = true;
                    break;
                }
            }
        }

        return bHasWhatAWants && aHasWhatBWants;
    }
}