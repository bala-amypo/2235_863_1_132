package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository matchRepository;
    private final SkillRequestRepository requestRepository;
    private final SkillOfferRepository offerRepository;

    public MatchServiceImpl(
            SkillMatchRepository matchRepository,
            SkillRequestRepository requestRepository,
            SkillOfferRepository offerRepository
    ) {
        this.matchRepository = matchRepository;
        this.requestRepository = requestRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public SkillMatch generateMatch(Long requestId) {
        SkillRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        SkillOffer offer = offerRepository.findByCategoryId(request.getCategory().getId())
                .stream()
                .filter(SkillOffer::isAvailable)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No matching offer found"));

        offer.setAvailable(false);
        offerRepository.save(offer);

        request.setStatus("MATCHED");
        requestRepository.save(request);

        return matchRepository.save(new SkillMatch(request, offer));
    }

    @Override
    public SkillMatch getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id " + id));
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return matchRepository.findAll();
    }
}
