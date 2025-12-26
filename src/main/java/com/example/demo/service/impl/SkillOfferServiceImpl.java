package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository repository;

    public SkillOfferServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createSkillOffer(SkillOffer offer) {
        return repository.save(offer);
    }

    @Override
    public List<SkillOffer> getAllSkillOffers() {
        return repository.findAll();
    }

    @Override
    public SkillOffer getSkillOfferById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SkillOffer not found"));
    }

    @Override
    public void deleteSkillOffer(Long id) {
        repository.deleteById(id);
    }
}
