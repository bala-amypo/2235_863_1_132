package com.example.demo.service.impl;

import com.example.demo.model.BarterTransaction;
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
    public List<BarterTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public BarterTransaction createTransaction(TransactionDto transactionDto) {
        BarterTransaction transaction = new BarterTransaction();
        transaction.setUserId(transactionDto.getUserId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setType(transactionDto.getType());
        // Set other fields if present
        return repository.save(transaction);
    }
}
