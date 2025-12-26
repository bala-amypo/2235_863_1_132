package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import java.util.List;
import java.util.Optional;

public interface SkillOfferRepository {

    SkillOffer save(SkillOffer offer);

    Optional<SkillOffer> findById(Long id);

    List<SkillOffer> findByUserId(Long userId);
}
