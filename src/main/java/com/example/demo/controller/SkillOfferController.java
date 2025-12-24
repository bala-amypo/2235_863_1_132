package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
@Tag(name = "Offer", description = "Skill offer management endpoints")
public class SkillOfferController {
    private final SkillOfferService skillOfferService;
    
    public SkillOfferController(SkillOfferService skillOfferService) {
        this.skillOfferService = skillOfferService;
    }
    
    @PostMapping("/")
    public ResponseEntity<SkillOffer> createOffer(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(skillOfferService.createOffer(offer));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillOffer>> getAllOffers() {
        return ResponseEntity.ok(skillOfferService.getAllOffers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok(skillOfferService.getOffer(id));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillOffer>> getOffersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillOfferService.getOffersByUser(userId));
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillOffer>> getOffersByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(skillOfferService.getOffersByCategory(categoryId));
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<SkillOffer>> getAvailableOffers() {
        return ResponseEntity.ok(skillOfferService.getAvailableOffers());
    }
}