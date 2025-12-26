package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;
import java.util.Optional;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    Optional<SkillOffer> getOfferById(Long id);
    List<SkillOffer> getAllOffers();
    List<SkillOffer> getOffersByUserId(Long userId);
    SkillOffer updateOffer(Long id, SkillOffer offer);
    void deleteOffer(Long id);
}
