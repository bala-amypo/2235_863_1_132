package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    
    private final SkillMatchRepository skillMatchRepository;
    private final SkillOfferRepository skillOfferRepository;
    private final SkillRequestRepository skillRequestRepository;
    private final UserRepository userRepository;
    
    public MatchServiceImpl(SkillMatchRepository skillMatchRepository, 
                           SkillOfferRepository skillOfferRepository,
                           SkillRequestRepository skillRequestRepository,
                           UserRepository userRepository) {
        this.skillMatchRepository = skillMatchRepository;
        this.skillOfferRepository = skillOfferRepository;
        this.skillRequestRepository = skillRequestRepository;
        this.userRepository = userRepository;
    }
    
    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
            .orElseThrow(() -> new ResourceNotFoundException("Offer not found"));
        SkillRequest request = skillRequestRepository.findById(requestId)
            .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        User admin = userRepository.findById(adminUserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        SkillMatch match = new SkillMatch(offer, request, admin);
        return skillMatchRepository.save(match);
    }
    
    @Override
    public SkillMatch getMatch(Long id) {
        return skillMatchRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
    
    @Override
    public List<SkillMatch> getAllMatches() {
        return skillMatchRepository.findAll();
    }
    
    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        match.setMatchStatus(status);
        return skillMatchRepository.save(match);
    }
    
    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return skillMatchRepository.findByOfferId(offerId);
    }
    
    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return skillMatchRepository.findByRequestId(requestId);
    }
}