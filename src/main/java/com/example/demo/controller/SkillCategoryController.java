package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService categoryService;

    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
}
