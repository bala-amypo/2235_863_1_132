package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchmakingService matchService;

    public MatchController(MatchmakingService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<MatchRecord> generate(@RequestParam Long requestId) {
        return ResponseEntity.ok(matchService.generateMatch(requestId));
    }

    @GetMapping
    public ResponseEntity<List<MatchRecord>> list() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }
}
