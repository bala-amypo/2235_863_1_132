package com.example.demo.dto;

public class TransactionDto {
    private Long userId;
    private Double amount;
    private String type;

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }
}
