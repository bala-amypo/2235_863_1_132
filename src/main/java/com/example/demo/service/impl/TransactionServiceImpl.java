package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BarterTransaction;
import com.example.demo.model.SkillMatch;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(
            BarterTransactionRepository transactionRepository,
            SkillMatchRepository matchRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public BarterTransaction create(Long matchId) {
        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        return transactionRepository.save(new BarterTransaction(match));
    }

    @Override
    public BarterTransaction getById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<BarterTransaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public BarterTransaction complete(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction tx = getById(transactionId);

        tx.setOffererRating(offererRating);
        tx.setRequesterRating(requesterRating);
        tx.setStatus("COMPLETED");
        tx.setCompletedAt(LocalDateTime.now());

        return transactionRepository.save(tx);
    }
}
