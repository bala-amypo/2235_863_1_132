package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class SkillCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<SkillOffer> offers;

    @OneToMany(mappedBy = "category")
    private Set<SkillRequest> requests;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<SkillOffer> getOffers() { return offers; }
    public void setOffers(Set<SkillOffer> offers) { this.offers = offers; }
    public Set<SkillRequest> getRequests() { return requests; }
    public void setRequests(Set<SkillRequest> requests) { this.requests = requests; }
}
