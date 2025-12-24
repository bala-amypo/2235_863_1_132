package com.example.demo.service.impl;

import com.example.demo.model.demoTransaction;
import com.example.demo.model.SkillMatch;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.exception.ResourceNotFoundException;
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
    public demoTransaction createTransaction(Long matchId) {

        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        demoTransaction transaction = new demoTransaction();
        transaction.setMatch(match);
        transaction.setStatus("IN_PROGRESS");

        return transactionRepository.save(transaction);
    }

    @Override
    public demoTransaction completeTransaction(Long transactionId,
                                                 Integer offererRating,
                                                 Integer requesterRating) {

        demoTransaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        transaction.setStatus("COMPLETED");
        transaction.setCompletedDate(LocalDateTime.now());
        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);

        return transactionRepository.save(transaction);
    }

    @Override
    public demoTransaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<demoTransaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }
}
