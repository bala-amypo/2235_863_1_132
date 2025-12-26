package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.BarterTransaction;

public interface TransactionService {

    BarterTransaction createTransaction(TransactionDto dto);
}
