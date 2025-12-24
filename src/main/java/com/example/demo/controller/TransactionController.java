package com.example.demo.controller;

import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction", description = "Barter transaction management endpoints")
public class TransactionController {
    private final TransactionService transactionService;
    
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping("/")
    public ResponseEntity<BarterTransaction> createTransaction(@RequestBody Map<String, Long> request) {
        return ResponseEntity.ok(transactionService.createTransaction(request.get("matchId")));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<BarterTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BarterTransaction> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }
    
    @PutMapping("/{id}/complete")
    public ResponseEntity<BarterTransaction> completeTransaction(
            @PathVariable Long id, 
            @RequestParam(required = false) Integer offererRating,
            @RequestParam(required = false) Integer requesterRating) {
        return ResponseEntity.ok(transactionService.completeTransaction(id, offererRating, requesterRating));
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BarterTransaction>> getTransactionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(transactionService.getTransactionsByStatus(status));
    }
}