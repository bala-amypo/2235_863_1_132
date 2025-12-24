package com.example.demo.controller;

import com.example.demo.model.demoTransaction;
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
    public ResponseEntity<demoTransaction> create(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.createTransaction(matchId));
    }

    @GetMapping
    public ResponseEntity<List<demoTransaction>> getAll() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<demoTransaction> get(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<demoTransaction> complete(
            @PathVariable Long id,
            @RequestParam Integer offererRating,
            @RequestParam Integer requesterRating) {

        return ResponseEntity.ok(
                transactionService.completeTransaction(id, offererRating, requesterRating)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<demoTransaction>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(transactionService.getTransactionsByStatus(status));
    }
}
