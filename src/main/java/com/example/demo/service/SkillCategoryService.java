package com.example.demo.service;

import com.example.demo.model.SkillCategory;
import java.util.List;

public interface SkillCategoryService {
    SkillCategory createSkill(SkillCategory skill);
    SkillCategory getSkillById(Long id);
    List<SkillCategory> getAllSkills();
    void deactivateSkill(Long id);
}