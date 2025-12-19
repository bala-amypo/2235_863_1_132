package com.example.demo.repository;

import com.example.demo.model.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillMatchRepository extends JpaRepository<SkillMatch, Long> {
    List<SkillMatch> findByUserA_IdOrUserB_Id(Long userAId, Long userBId);
    List<SkillMatch> findByStatus(String status);
}