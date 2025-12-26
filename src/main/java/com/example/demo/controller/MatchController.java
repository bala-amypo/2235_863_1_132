package com.example.demo.controller;

import com.example.demo.dto.MatchDto;
import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<SkillMatch> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping
    public ResponseEntity<SkillMatch> createMatch(@RequestBody MatchDto dto) {
        return ResponseEntity.ok(matchService.createMatch(dto));
    }
}
