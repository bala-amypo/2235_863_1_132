package com.example.demo.service.impl;

import com.example.demo.model.BarterTransaction;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository repository;

    public TransactionServiceImpl(BarterTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BarterTransaction createTransaction(BarterTransaction tx) {
        return repository.save(tx);
    }

    @Override
    public List<BarterTransaction> getAllTransactions() {
        return repository.findAll();
    }
}