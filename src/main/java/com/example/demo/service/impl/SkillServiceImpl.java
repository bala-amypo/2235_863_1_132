package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    @Override
    public SkillCategory create(SkillCategory category) {
        return category;
    }

    @Override
    public List<SkillCategory> getAll() {
        return List.of();
    }
}
