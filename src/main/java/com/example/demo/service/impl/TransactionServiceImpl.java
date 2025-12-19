package com.example.demo.service.impl;

import com.example.demo.model.BarterTransaction;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final BarterTransactionRepository transactionRepository;

    // Constructor Injection
    public TransactionServiceImpl(BarterTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BarterTransaction createTransaction(BarterTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction getTransactionByMatchId(Long matchId) {
        return transactionRepository.findByMatchRecord_Id(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<BarterTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}