package com.example.demo.service;

import com.example.demo.model.SkillMatch;
import java.util.List;

public interface MatchService {

    SkillMatch generateMatch(Long requestId);

    List<SkillMatch> getMatchesForUser(Long userId);
}
