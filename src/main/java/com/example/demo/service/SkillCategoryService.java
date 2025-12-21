package com.example.demo;

import java.util.List;

public interface SkillCategoryService {
    SkillCategory createCategory(SkillCategory category);
    SkillCategory getCategory(Long id);
    List<SkillCategory> getAllCategories();
}