package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository requestRepository;

    public SkillRequestServiceImpl(SkillRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public SkillRequest getRequestById(Long requestId) {
        return requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill request not found"));
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }

    @Override
    public List<SkillRequest> getOpenRequests() {
        return requestRepository.findByStatus("OPEN");
    }
}
