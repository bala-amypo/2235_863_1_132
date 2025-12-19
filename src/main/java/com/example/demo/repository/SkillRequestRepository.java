package com.example.demo.repository;

import com.example.demo.model.SkillRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRequestRepository extends JpaRepository<SkillRequest, Long> {
    // Add this line to fix the MatchService error
    List<SkillRequest> findByUser_IdAndActiveTrue(Long userId);
}