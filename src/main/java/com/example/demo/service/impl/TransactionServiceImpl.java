package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BarterTransaction;
import com.example.demo.model.SkillMatch;
import com.example.demo.repository.BarterTransactionRepository;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository barterTransactionRepository;
    private final SkillMatchRepository skillMatchRepository;
    
    public TransactionServiceImpl(BarterTransactionRepository barterTransactionRepository,
                                 SkillMatchRepository skillMatchRepository) {
        this.barterTransactionRepository = barterTransactionRepository;
        this.skillMatchRepository = skillMatchRepository;
    }
    
    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = skillMatchRepository.findById(matchId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
            
        if (!"ACCEPTED".equals(match.getMatchStatus())) {
            throw new BadRequestException("Match must be accepted before creating transaction");
        }
        
        BarterTransaction transaction = new BarterTransaction(match);
        return barterTransactionRepository.save(transaction);
    }
    
    @Override
    public BarterTransaction getTransaction(Long id) {
        return barterTransactionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }
    
    @Override
    public List<BarterTransaction> getAllTransactions() {
        return barterTransactionRepository.findAll();
    }
    
    @Override
    public BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = getTransaction(transactionId);
        
        if (offererRating != null && (offererRating < 1 || offererRating > 5)) {
            throw new BadRequestException("Offerer rating must be between 1 and 5");
        }
        if (requesterRating != null && (requesterRating < 1 || requesterRating > 5)) {
            throw new BadRequestException("Requester rating must be between 1 and 5");
        }
        
        transaction.setStatus("COMPLETED");
        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setCompletedAt(LocalDateTime.now());
        
        return barterTransactionRepository.save(transaction);
    }
    
    @Override
    public List<BarterTransaction> getTransactionsByStatus(String status) {
        return barterTransactionRepository.findByStatus(status);
    }
}