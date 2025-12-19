package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category")
public class SkillCategoryController {
    
    private final SkillCategoryService skillCategoryService;
    
    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }
    
    @PostMapping("/")
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        SkillCategory created = skillCategoryService.createCategory(category);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        List<SkillCategory> categories = skillCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        SkillCategory category = skillCategoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }
}