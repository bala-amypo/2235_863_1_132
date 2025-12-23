package com.example.barter.service;

import com.example.barter.model.SkillRequest;

import java.util.List;

public interface SkillRequestService {

    SkillRequest createRequest(SkillRequest request);

    SkillRequest getRequestById(Long requestId);

    List<SkillRequest> getRequestsByUser(Long userId);

    List<SkillRequest> getOpenRequests();
}
