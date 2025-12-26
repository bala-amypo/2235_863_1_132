package com.example.demo.controller;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public SkillMatch get(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @GetMapping
    public List<SkillMatch> all() {
        return matchService.getAllMatches();
    }
}
