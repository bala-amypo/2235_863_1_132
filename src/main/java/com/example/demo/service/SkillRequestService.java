package com.example.demo.service;

import com.example.demo.model.SkillRequest;

import java.util.List;

public interface SkillRequestService {

    SkillRequest createRequest(SkillRequest request);

    SkillRequest getRequestById(Long requestId);

    List<SkillRequest> getRequestsByUser(Long userId);

    List<SkillRequest> getOpenRequests();
}
