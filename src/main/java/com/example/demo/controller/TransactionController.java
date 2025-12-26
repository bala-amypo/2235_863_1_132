package com.example.demo.controller;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BarterTransaction> create(@RequestBody TransactionDto dto) {
        return ResponseEntity.ok(service.createTransaction(dto));
    }
}
