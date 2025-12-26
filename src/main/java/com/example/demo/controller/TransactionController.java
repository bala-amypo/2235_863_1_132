package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.create(matchId));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> list() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getById(id));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Transaction> complete(
            @PathVariable Long id,
            @RequestParam Integer offererRating,
            @RequestParam Integer requesterRating
    ) {
        return ResponseEntity.ok(
                transactionService.complete(id, offererRating, requesterRating)
        );
    }
}
