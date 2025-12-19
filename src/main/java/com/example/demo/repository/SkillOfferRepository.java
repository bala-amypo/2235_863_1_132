package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findByUserId(Long userId);
    
    // These are required for your MatchmakingService errors
    List<SkillOffer> findByUser_IdAndActiveTrue(Long userId);
    List<SkillOffer> findBySkill_IdAndActiveTrue(Long skillId);
}