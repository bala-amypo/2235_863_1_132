package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;
import java.util.Optional;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    Optional<SkillRequest> getRequestById(Long id);
    List<SkillRequest> getAllRequests();
    List<SkillRequest> getRequestsByUserId(Long userId);
    SkillRequest updateRequest(Long id, SkillRequest request);
    void deleteRequest(Long id);
}
