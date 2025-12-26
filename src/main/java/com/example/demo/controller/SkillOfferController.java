package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class SkillOfferController {

    @Autowired
    private SkillOfferService offerService;

    @GetMapping
    public List<SkillOffer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping
    public ResponseEntity<SkillOffer> createOffer(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(offerService.createOffer(offer));
    }
}
