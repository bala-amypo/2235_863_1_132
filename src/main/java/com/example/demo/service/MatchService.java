package com.example.demo.service;

import com.example.demo.model.SkillMatch;
import java.util.List;

public interface MatchService {
    SkillMatch generateMatch(Long userId);
    List<SkillMatch> getMatchesForUser(Long userId);
    void updateMatchStatus(Long matchId, String status);
}