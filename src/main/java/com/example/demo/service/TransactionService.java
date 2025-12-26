package com.example.demo.service;

import com.example.demo.model.demoTransaction;

import java.util.List;

public interface TransactionService {

    demoTransaction create(Long matchId);

    demoTransaction getById(Long id);

    List<demoTransaction> getAll();

    demoTransaction complete(
            Long transactionId,
            Integer offererRating,
            Integer requesterRating
    );
}
