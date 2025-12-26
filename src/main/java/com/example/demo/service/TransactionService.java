package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction createTransaction(TransactionDto dto);
    void complete(Long id, Integer someField1, Integer someField2);
}
