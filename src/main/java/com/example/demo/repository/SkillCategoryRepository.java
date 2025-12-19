package com.example.demo.repository;

import com.example.demo.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    List<SkillCategory> findByActiveTrue();
    boolean existsByName(String name);
}