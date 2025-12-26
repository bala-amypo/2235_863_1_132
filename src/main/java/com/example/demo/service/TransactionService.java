package com.example.demo.service;

import com.example.demo.model.BarterTransaction;

import java.util.List;

public interface TransactionService {

    BarterTransaction create(Long matchId);

    BarterTransaction getById(Long id);

    List<BarterTransaction> getAll();

    BarterTransaction complete(
            Long transactionId,
            Integer offererRating,
            Integer requesterRating
    );
}
