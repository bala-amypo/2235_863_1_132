package com.example.demo.service.impl;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Override
    public SkillMatch generateMatch(Long requestId) {
        SkillMatch match = new SkillMatch();
        match.setStatus("PENDING");
        return match;
    }

    @Override
    public List<SkillMatch> getMatchesForUser(Long userId) {
        return List.of();
    }
}
