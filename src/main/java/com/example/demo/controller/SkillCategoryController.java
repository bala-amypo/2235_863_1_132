package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "SkillController")
public class SkillCategoryController {
    private final SkillService skillService;

    public SkillCategoryController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/")
    public SkillCategory create(@RequestBody SkillCategory skill) {
        return skillService.createSkill(skill);
    }

    @GetMapping("/")
    public List<SkillCategory> getAll() {
        return skillService.getAllSkills();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
    }
}