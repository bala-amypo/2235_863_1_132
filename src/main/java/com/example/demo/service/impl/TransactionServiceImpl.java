package com.example.barter.service.impl;

import com.example.barter.model.BarterTransaction;
import com.example.barter.model.SkillMatch;
import com.example.barter.repository.BarterTransactionRepository;
import com.example.barter.repository.SkillMatchRepository;
import com.example.barter.service.TransactionService;
import com.example.barter.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(BarterTransactionRepository transactionRepository,
                                  SkillMatchRepository matchRepository) {
        this.transactionRepository = transactionRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {

        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("IN_PROGRESS");

        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction completeTransaction(Long transactionId,
                                                 Integer offererRating,
                                                 Integer requesterRating) {

        BarterTransaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        transaction.setStatus("COMPLETED");
        transaction.setCompletedDate(LocalDateTime.now());
        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);

        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<BarterTransaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }
}
