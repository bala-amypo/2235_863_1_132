package com.example.demo.service.impl;

import com.example.demo.model.SkillMatch;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository repository;

    public MatchServiceImpl(SkillMatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillMatch createMatch(SkillMatch match) {
        return repository.save(match);
    }

    @Override
    public Optional<SkillMatch> getMatchById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return repository.findAll();
    }

    @Override
    public List<SkillMatch> getMatchesByOfferOrRequestId(Long offerId, Long requestId) {
        return repository.findByOfferIdOrRequestId(offerId, requestId);
    }

    @Override
    public void deleteMatch(Long id) {
        repository.deleteById(id);
    }
}
