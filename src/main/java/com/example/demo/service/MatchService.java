package com.example.demo.service;

import com.example.demo.model.SkillMatch;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    List<SkillMatch> getAllMatches();
    Optional<SkillMatch> getMatchById(Long id); // use Optional
    SkillMatch createMatch(SkillMatch match);
}
