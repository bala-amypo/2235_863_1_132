package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Skill category management endpoints")
public class SkillCategoryController {
    private final SkillCategoryService skillCategoryService;
    
    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }
    
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(skillCategoryService.createCategory(category));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(skillCategoryService.getAllCategories());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(skillCategoryService.getCategory(id));
    }
}