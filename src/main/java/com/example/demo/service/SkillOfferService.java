package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createSkillOffer(SkillOffer offer);
    List<SkillOffer> getAllSkillOffers();
    SkillOffer getSkillOfferById(Long id);
    void deleteSkillOffer(Long id);
}
