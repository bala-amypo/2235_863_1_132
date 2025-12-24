package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "skill_categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = "categoryName")
})
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "skillCategory")
    private List<SkillOffer> skillOffers;

    @OneToMany(mappedBy = "skillCategory")
    private List<SkillRequest> skillRequests;

    public SkillCategory() {}

    public SkillCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public List<SkillOffer> getSkillOffers() { return skillOffers; }
    public void setSkillOffers(List<SkillOffer> skillOffers) { this.skillOffers = skillOffers; }

    public List<SkillRequest> getSkillRequests() { return skillRequests; }
    public void setSkillRequests(List<SkillRequest> skillRequests) { this.skillRequests = skillRequests; }
}
