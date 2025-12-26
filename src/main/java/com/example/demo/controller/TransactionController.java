package com.example.barter.controller;

import com.example.barter.model.BarterTransaction;
import com.example.barter.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public BarterTransaction get(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @GetMapping
    public List<BarterTransaction> all() {
        return transactionService.getAll();
    }
}
