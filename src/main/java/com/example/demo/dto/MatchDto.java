package com.example.demo.dto;

public class MatchDto {

    private Long id;
    private Long skillRequestId;
    private Long skillOfferId;
    private String status;

    public MatchDto() {
    }

    public MatchDto(Long id, Long skillRequestId, Long skillOfferId, String status) {
        this.id = id;
        this.skillRequestId = skillRequestId;
        this.skillOfferId = skillOfferId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getSkillRequestId() {
        return skillRequestId;
    }

    public Long getSkillOfferId() {
        return skillOfferId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillRequestId(Long skillRequestId) {
        this.skillRequestId = skillRequestId;
    }

    public void setSkillOfferId(Long skillOfferId) {
        this.skillOfferId = skillOfferId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
