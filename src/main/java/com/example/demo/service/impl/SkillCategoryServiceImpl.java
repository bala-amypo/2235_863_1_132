package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {
    private final SkillCategoryRepository repository;

    public SkillCategoryServiceImpl(SkillCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillCategory createSkill(SkillCategory skill) {
        return repository.save(skill);
    }

    @Override
    public SkillCategory getSkillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public List<SkillCategory> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public void deactivateSkill(Long id) {
        SkillCategory skill = getSkillById(id);
        skill.setActive(false);
        repository.save(skill);
    }
}