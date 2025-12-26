package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SkillCategoryController {

    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SkillCategory> create(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(service.create(category));
    }

    @GetMapping
    public ResponseEntity<List<SkillCategory>> list() {
        return ResponseEntity.ok(service.getAll());
    }
}
