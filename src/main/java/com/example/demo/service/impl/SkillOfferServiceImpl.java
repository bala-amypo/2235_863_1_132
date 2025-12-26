package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
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
    public SkillOffer getOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SkillOffer not found with id " + id));
    }

    @Override
    public List<SkillOffer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return offerRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return offerRepository.findByAvailableTrue();
    }
}
