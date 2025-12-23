package com.example.barter.service.impl;

import com.example.barter.model.SkillOffer;
import com.example.barter.repository.SkillOfferRepository;
import com.example.barter.service.SkillOfferService;
import com.example.barter.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository offerRepository;

    public SkillOfferServiceImpl(SkillOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public SkillOffer getOfferById(Long offerId) {
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill offer not found"));
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return offerRepository.findByAvailability("AVAILABLE");
    }
}
