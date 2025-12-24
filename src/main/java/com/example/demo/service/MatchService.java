package com.example.demo.service;

import com.example.demo.model.SkillMatch;

import java.util.List;

public interface MatchService {

    SkillMatch createMatch(Long offerId, Long requestId, Long matchedByUserId);

    SkillMatch getMatchById(Long matchId);

    List<SkillMatch> getMatchesByStatus(String status);

    List<SkillMatch> getMatchesByUser(Long userId);
}
