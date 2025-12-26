package com.example.demo.repository;

import com.example.demo.model.SkillRequest;
import java.util.List;
import java.util.Optional;

public interface SkillRequestRepository {

    SkillRequest save(SkillRequest request);

    Optional<SkillRequest> findById(Long id);

    List<SkillRequest> findByUserId(Long userId);
}
