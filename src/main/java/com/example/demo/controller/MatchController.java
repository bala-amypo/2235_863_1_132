package com.example.demo.controller;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/{requestId}")
    public ResponseEntity<SkillMatch> generate(@PathVariable Long requestId) {
        return ResponseEntity.ok(service.generateMatch(requestId));
    }
}
