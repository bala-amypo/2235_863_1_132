package com.example.demo.controller;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchmakingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "MatchRecordController")
public class MatchController {
    private final MatchmakingService service;

    public MatchController(MatchmakingService service) {
        this.service = service;
    }

    @PostMapping("/generate/{userId}")
    public SkillMatch generate(@PathVariable Long userId) {
        return service.generateMatch(userId);
    }

    @GetMapping("/user/{userId}")
    public List<SkillMatch> getForUser(@PathVariable Long userId) {
        return service.getMatchesForUser(userId);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateMatchStatus(id, status);
    }
}