package com.example.demo.dto;

import com.example.demo.model.demoTransaction;

import java.time.LocalDateTime;

public class TransactionDto {

    private Long id;
    private Long offerId;
    private Long requestId;
    private LocalDateTime transactionTime;

    public TransactionDto() {}

    public TransactionDto(demoTransaction transaction) {
        this.id = transaction.getId();
        this.offerId = transaction.getOffer().getId();
        this.requestId = transaction.getRequest().getId();
        this.transactionTime = transaction.getTransactionTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
