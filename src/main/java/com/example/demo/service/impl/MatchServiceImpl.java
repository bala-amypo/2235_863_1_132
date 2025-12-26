package com.example.demo.service.impl;

import com.example.demo.model.SkillMatch;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private SkillMatchRepository repository;

    @Override
    public List<SkillMatch> getAllMatches() {
        return repository.findAll();
    }

    @Override
    public Optional<SkillMatch> getMatchById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SkillMatch createMatch(SkillMatch match) {
        return repository.save(match);
    }
}
