package com.example.demo.dto;

public class MatchDto {

    private Long user1Id;
    private Long user2Id;
    private String skill;

    public Long getUser1Id() { return user1Id; }
    public void setUser1Id(Long user1Id) { this.user1Id = user1Id; }

    public Long getUser2Id() { return user2Id; }
    public void setUser2Id(Long user2Id) { this.user2Id = user2Id; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }
}
