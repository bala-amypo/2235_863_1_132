package com.example.demo.controller;

import com.example.demo.model.demoTransaction;
import com.example.demo.service.TransactionService;
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
    public demoTransaction get(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @GetMapping
    public List<demoTransaction> all() {
        return transactionService.getAll();
    }
}
