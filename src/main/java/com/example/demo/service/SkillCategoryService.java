package com.example.demo.service;

import com.example.demo.model.SkillCategory;
import java.util.List;
import java.util.Optional;

public interface SkillCategoryService {
    SkillCategory createCategory(SkillCategory category);
    Optional<SkillCategory> getCategoryById(Long id);
    List<SkillCategory> getAllCategories();
    SkillCategory updateCategory(Long id, SkillCategory category);
    void deleteCategory(Long id);
}
