package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skill-offers")
@Tag(name = "SkillOfferController")
public class SkillOfferController {
    private final SkillOfferService service;

    public SkillOfferController(SkillOfferService service) {
        this.service = service;
    }

    @PostMapping("/")
    public SkillOffer create(@RequestBody SkillOffer offer) {
        return service.createOffer(offer);
    }

    @GetMapping("/user/{userId}")
    public List<SkillOffer> getByUser(@PathVariable Long userId) {
        return service.getOffersByUser(userId);
    }
}