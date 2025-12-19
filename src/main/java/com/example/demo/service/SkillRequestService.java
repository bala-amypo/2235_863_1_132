package com.example.demo;

import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequest(Long id);
    List<SkillRequest> getRequestsByUser(Long userId);
    List<SkillRequest> getRequestsByCategory(Long categoryId);
    List<SkillRequest> getOpenRequests();
    List<SkillRequest> getAllRequests();
}