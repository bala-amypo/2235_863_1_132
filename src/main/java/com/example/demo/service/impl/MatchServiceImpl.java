package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.MatchService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository matchRepository;
    private final SkillOfferRepository offerRepository;
    private final SkillRequestRepository requestRepository;
    private final UserRepository userRepository;

    public MatchServiceImpl(SkillMatchRepository matchRepository,
                            SkillOfferRepository offerRepository,
                            SkillRequestRepository requestRepository,
                            UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.offerRepository = offerRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long matchedByUserId) {

        SkillOffer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found"));

        SkillRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        User user = userRepository.findById(matchedByUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(user);
        match.setMatchStatus("PENDING");
        match.setMatchScore(0.0);

        return matchRepository.save(match);
    }

    @Override
    public SkillMatch getMatchById(Long matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }

    @Override
    public List<SkillMatch> getMatchesByStatus(String status) {
        return matchRepository.findByMatchStatus(status);
    }

    @Override
    public List<SkillMatch> getMatchesByUser(Long userId) {
        return matchRepository.findByMatchedById(userId);
    }
}
