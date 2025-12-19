package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final SkillOfferRepository offerRepo;
    private final SkillRequestRepository requestRepo;
    private final SkillMatchRepository matchRepo;

    public MatchServiceImpl(SkillOfferRepository offerRepo, 
                            SkillRequestRepository requestRepo, 
                            SkillMatchRepository matchRepo) {
        this.offerRepo = offerRepo;
        this.requestRepo = requestRepo;
        this.matchRepo = matchRepo;
    }

    @Override
    public SkillMatch generateMatch(Long userId) {
        List<SkillRequest> myRequests = requestRepo.findByUser_IdAndActiveTrue(userId);
        List<SkillOffer> myOffers = offerRepo.findByUser_IdAndActiveTrue(userId);

        for (SkillRequest req : myRequests) {
            // Find who offers what I want
            List<SkillOffer> potentialMatches = offerRepo.findBySkill_IdAndActiveTrue(req.getSkill().getId());
            
            for (SkillOffer peerOffer : potentialMatches) {
                Long peerId = peerOffer.getUser().getId();
                if (peerId.equals(userId)) continue;

                // Check if peer wants what I offer
                for (SkillOffer myOffer : myOffers) {
                    List<SkillRequest> peerRequests = requestRepo.findByUser_IdAndActiveTrue(peerId);
                    boolean peerWantsMySkill = peerRequests.stream()
                        .anyMatch(pr -> pr.getSkill().getId().equals(myOffer.getSkill().getId()));

                    if (peerWantsMySkill) {
                        SkillMatch match = new SkillMatch();
                        match.setUserA(req.getUser());
                        match.setUserB(peerOffer.getUser());
                        match.setSkillOfferedByA(myOffer.getSkill());
                        match.setSkillOfferedByB(peerOffer.getSkill());
                        match.setStatus("PENDING");
                        return matchRepo.save(match);
                    }
                }
            }
        }
        throw new RuntimeException("No match found");
    }

    @Override
    public List<SkillMatch> getMatchesForUser(Long userId) {
        return matchRepo.findByUserA_IdOrUserB_Id(userId, userId);
    }

    @Override
    public void updateMatchStatus(Long matchId, String status) {
        SkillMatch match = matchRepo.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        match.setStatus(status);
        matchRepo.save(match);
    }
}