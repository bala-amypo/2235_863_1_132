package com.example.demo.service.impl;

import com.example.demo.model.BarterTransaction;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final BarterTransactionRepository repository;

    public TransactionServiceImpl(BarterTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BarterTransaction createTransaction(BarterTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Optional<BarterTransaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BarterTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public List<BarterTransaction> getTransactionsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
