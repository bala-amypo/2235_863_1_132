package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import com.example.demo.exception.ResourceNotFoundException; // Ensure this exists or use RuntimeException
import org.springframework.stereotype.Service;
import java.util.List;

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
    public List<SkillOffer> getOffersByUserId(Long userId) {
        // This matches the findByUserId method we added to your Repository
        return repository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getAllOffers() {
        return repository.findAll();
    }

    @Override
    public void deactivateOffer(Long id) {
        // This fixes the "is not abstract and does not override" error
        SkillOffer offer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill Offer not found with id: " + id));
        
        // If your SkillOffer model has an 'active' boolean field:
        // offer.setActive(false);
        // repository.save(offer);
        
        // OR if you just want to delete it:
        repository.delete(offer);
    }
}