package com.example.barter.service.impl;

import com.example.barter.model.SkillCategory;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillCategoryService;
import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository categoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new BadRequestException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public SkillCategory getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
