package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.demoTransaction;
import com.example.demo.model.SkillMatch;
import com.example.demo.repository.demoTransactionRepository;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final demoTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(
            demoTransactionRepository transactionRepository,
            SkillMatchRepository matchRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public demoTransaction create(Long matchId) {
        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        return transactionRepository.save(new demoTransaction(match));
    }

    @Override
    public demoTransaction getById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<demoTransaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public demoTransaction complete(Long transactionId, Integer offererRating, Integer requesterRating) {
        demoTransaction tx = getById(transactionId);

        tx.setOffererRating(offererRating);
        tx.setRequesterRating(requesterRating);
        tx.setStatus("COMPLETED");
        tx.setCompletedAt(LocalDateTime.now());

        return transactionRepository.save(tx);
    }
}
