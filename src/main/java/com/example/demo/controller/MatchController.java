package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    
    private final MatchService matchService;
    
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    
    @PostMapping
    public ResponseEntity<SkillMatch> createMatch(@RequestParam Long offerId, 
                                                 @RequestParam Long requestId, 
                                                 @RequestParam Long adminUserId) {
        return ResponseEntity.ok(matchService.createMatch(offerId, requestId, adminUserId));
    }
    
    @GetMapping
    public ResponseEntity<List<SkillMatch>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillMatch> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<SkillMatch> updateMatchStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(matchService.updateMatchStatus(id, status));
    }
    
    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(matchService.getMatchesByOffer(offerId));
    }
    
    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByRequest(@PathVariable Long requestId) {
        return ResponseEntity.ok(matchService.getMatchesByRequest(requestId));
    }
}