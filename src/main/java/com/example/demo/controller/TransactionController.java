package com.example.demo.controller;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<BarterTransaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<BarterTransaction> createTransaction(@RequestBody TransactionDto dto) {
        return ResponseEntity.ok(transactionService.createTransaction(dto));
    }
}
