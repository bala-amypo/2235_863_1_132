package com.example.barter.controller;

import com.example.barter.model.SkillCategory;
import com.example.barter.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SkillCategoryController {

    private final SkillCategoryService categoryService;

    public SkillCategoryController(SkillCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public SkillCategory get(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public List<SkillCategory> all() {
        return categoryService.getAllCategories();
    }
}
