package com.example.demo.service;

import com.example.demo.model.BarterTransaction;
import java.util.List;

public interface TransactionService {
    BarterTransaction createTransaction(BarterTransaction transaction);
    BarterTransaction getTransactionByMatchId(Long matchId);
    List<BarterTransaction> getAllTransactions();
}