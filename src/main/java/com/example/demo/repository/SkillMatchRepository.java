package com.example.demo.repository;

import com.example.demo.model.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillMatchRepository extends JpaRepository<SkillMatch, Long> {

    List<SkillMatch> findByMatchStatus(String matchStatus);

    List<SkillMatch> findByMatchedById(Long userId);
}
