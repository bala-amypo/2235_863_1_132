package com.example.demo.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long transactionId;
    private Long matchId;
    private String notes;
    private LocalDateTime completedAt;

    public TransactionDto() {}

    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long id) { this.transactionId = id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}