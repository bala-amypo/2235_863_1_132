package com.example.demo.dto;

public class TransactionDto {

    private Long fromUserId;
    private Long toUserId;
    private Long matchId;

    public TransactionDto() {}

    public TransactionDto(Long fromUserId, Long toUserId, Long matchId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.matchId = matchId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
