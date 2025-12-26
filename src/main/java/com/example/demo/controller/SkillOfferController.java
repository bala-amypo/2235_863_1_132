package com.example.barter.controller;

import com.example.barter.model.SkillOffer;
import com.example.barter.service.SkillOfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class SkillOfferController {

    private final SkillOfferService offerService;

    public SkillOfferController(SkillOfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public SkillOffer create(@RequestBody SkillOffer offer) {
        return offerService.createOffer(offer);
    }

    @GetMapping("/{id}")
    public SkillOffer get(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @GetMapping
    public List<SkillOffer> all() {
        return offerService.getAllOffers();
    }
}
