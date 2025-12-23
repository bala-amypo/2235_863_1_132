package com.example.barter.service;

import com.example.barter.model.BarterTransaction;

import java.util.List;

public interface TransactionService {

    BarterTransaction createTransaction(Long matchId);

    BarterTransaction completeTransaction(Long transactionId,
                                          Integer offererRating,
                                          Integer requesterRating);

    BarterTransaction getTransactionById(Long transactionId);

    List<BarterTransaction> getTransactionsByStatus(String status);
}
