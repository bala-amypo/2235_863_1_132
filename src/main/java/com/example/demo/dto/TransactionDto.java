package com.example.demo.dto;

import java.time.LocalDateTime;

public class TransactionDto {

    private Long id;
    private Long matchId;
    private String status;
    private Integer offererRating;
    private Integer requesterRating;
    private LocalDateTime completedAt;

    public TransactionDto() {
    }

    public TransactionDto(
            Long id,
            Long matchId,
            String status,
            Integer offererRating,
            Integer requesterRating,
            LocalDateTime completedAt
    ) {
        this.id = id;
        this.matchId = matchId;
        this.status = status;
        this.offererRating = offererRating;
        this.requesterRating = requesterRating;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public String getStatus() {
        return status;
    }

    public Integer getOffererRating() {
        return offererRating;
    }

    public Integer getRequesterRating() {
        return requesterRating;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOffererRating(Integer offererRating) {
        this.offererRating = offererRating;
    }

    public void setRequesterRating(Integer requesterRating) {
        this.requesterRating = requesterRating;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
