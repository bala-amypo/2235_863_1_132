package com.example.demo.service;

import com.example.demo.model.BarterTransaction;
import com.example.demo.dto.TransactionDto;
import java.util.List;

public interface TransactionService {
    List<BarterTransaction> getAllTransactions();
    BarterTransaction createTransaction(TransactionDto transactionDto);
}
