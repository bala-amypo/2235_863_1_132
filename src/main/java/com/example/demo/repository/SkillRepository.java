package com.example.demo.repository;

import com.example.demo.model.SkillCategory;
import java.util.List;
import java.util.Optional;

public interface SkillCategoryRepository {

    SkillCategory save(SkillCategory category);

    Optional<SkillCategory> findById(Long id);

    List<SkillCategory> findAll();
}
