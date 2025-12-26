package com.example.demo.service;

import com.example.demo.model.SkillCategory;

import java.util.List;

public interface SkillCategoryService {
    List<SkillCategory> getAllCategories();
    SkillCategory getCategoryById(Long id);
    SkillCategory createCategory(SkillCategory category);
    void deleteCategory(Long id);
}
