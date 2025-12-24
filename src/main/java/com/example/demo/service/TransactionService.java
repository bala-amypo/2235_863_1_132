package com.example.demo.service;

import com.example.demo.model.demoTransaction;

import java.util.List;

public interface TransactionService {

    demoTransaction createTransaction(Long matchId);

    demoTransaction completeTransaction(Long transactionId,
                                          Integer offererRating,
                                          Integer requesterRating);

    demoTransaction getTransactionById(Long transactionId);

    List<demoTransaction> getTransactionsByStatus(String status);
}
