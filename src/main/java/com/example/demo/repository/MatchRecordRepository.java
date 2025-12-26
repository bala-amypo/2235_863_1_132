package com.example.demo.repository;

import com.example.demo.model.SkillMatch;
import java.util.List;
import java.util.Optional;

public interface SkillMatchRepository {

    SkillMatch save(SkillMatch match);

    Optional<SkillMatch> findById(Long id);

    List<SkillMatch> findByUserAIdOrUserBId(Long userAId, Long userBId);
}
