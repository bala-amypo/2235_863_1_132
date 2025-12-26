package com.example.demo.service;

import com.example.demo.model.SkillMatch;

import java.util.List;

public interface MatchService {

    SkillMatch generateMatch(Long requestId);

    SkillMatch getMatchById(Long id);

    List<SkillMatch> getAllMatches();
}
