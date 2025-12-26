package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository repository;

    public SkillOfferServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return repository.save(offer);
    }

    @Override
    public Optional<SkillOffer> getOfferById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SkillOffer> getAllOffers() {
        return repository.findAll();
    }

    @Override
    public List<SkillOffer> getOffersByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public SkillOffer updateOffer(Long id, SkillOffer offer) {
        offer.setId(id);
        return repository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        repository.deleteById(id);
    }
}
