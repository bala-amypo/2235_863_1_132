package com.example.demo.dto;

import java.time.LocalDateTime;

public class MatchDto {
    private Long matchId;
    private String userAName;
    private String userBName;
    private String skillFromA;
    private String skillFromB;
    private String status;
    private LocalDateTime matchedAt;

    public MatchDto() {}

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public String getUserAName() { return userAName; }
    public void setUserAName(String name) { this.userAName = name; }

    public String getUserBName() { return userBName; }
    public void setUserBName(String name) { this.userBName = name; }

    public String getSkillFromA() { return skillFromA; }
    public void setSkillFromA(String skill) { this.skillFromA = skill; }

    public String getSkillFromB() { return skillFromB; }
    public void setSkillFromB(String skill) { this.skillFromB = skill; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getMatchedAt() { return matchedAt; }
    public void setMatchedAt(LocalDateTime matchedAt) { this.matchedAt = matchedAt; }
}