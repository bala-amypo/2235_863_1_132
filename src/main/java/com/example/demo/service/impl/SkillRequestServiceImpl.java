package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository skillRequestRepository;

    // Constructor Injection
    public SkillRequestServiceImpl(SkillRequestRepository skillRequestRepository) {
        this.skillRequestRepository = skillRequestRepository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return skillRequestRepository.save(request);
    }

    @Override
    public List<SkillRequest> getRequestsByUserId(Long userId) {
        // Ensure your Repository has a method: List<SkillRequest> findByUserId(Long userId);
        return skillRequestRepository.findByUserId(userId);
    }

    @Override
    public List<SkillRequest> getAllRequests() {
        return skillRequestRepository.findAll();
    }

    @Override
    public void deleteRequest(Long id) {
        skillRequestRepository.deleteById(id);
    }
}