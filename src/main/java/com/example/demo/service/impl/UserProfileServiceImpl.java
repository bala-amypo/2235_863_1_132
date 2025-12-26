package com.example.demo.service.impl;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public BarterTransaction createTransaction(TransactionDto dto) {
        BarterTransaction tx = new BarterTransaction();
        tx.setRemarks(dto.getRemarks());
        return tx;
    }
}
