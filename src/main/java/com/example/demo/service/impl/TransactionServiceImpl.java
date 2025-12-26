package com.example.demo.service.impl;

import com.example.demo.model.Transaction;
import com.example.demo.dto.TransactionDto;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BarterTransactionRepository repository;

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Transaction createTransaction(TransactionDto dto) {
        Transaction transaction = new Transaction();
        // map DTO to entity here
        return repository.save(transaction);
    }

    @Override
    public void complete(Long id, Integer field1, Integer field2) {
        // implement complete logic
    }
}
