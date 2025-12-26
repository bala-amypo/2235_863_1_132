package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "barter_transactions")
public class BarterTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SkillOffer offer;

    @ManyToOne
    private SkillRequest request;

    private LocalDateTime transactionTime;

    public BarterTransaction() {}

    public BarterTransaction(SkillOffer offer, SkillRequest request, LocalDateTime transactionTime) {
        this.offer = offer;
        this.request = request;
        this.transactionTime = transactionTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }

    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }

    public LocalDateTime getTransactionTime() { return transactionTime; }
    public void setTransactionTime(LocalDateTime transactionTime) { this.transactionTime = transactionTime; }
}
