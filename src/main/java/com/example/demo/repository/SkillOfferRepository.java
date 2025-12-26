package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findByUser(User user);
}
