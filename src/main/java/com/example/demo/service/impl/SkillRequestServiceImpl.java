package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {
    private final SkillRequestRepository skillRequestRepository;
    private final SkillCategoryRepository skillCategoryRepository;
    
    public SkillRequestServiceImpl(SkillRequestRepository skillRequestRepository, SkillCategoryRepository skillCategoryRepository) {
        this.skillRequestRepository = skillRequestRepository;
        this.skillCategoryRepository = skillCategoryRepository;
    }
    
    @Override
    public SkillRequest createRequest(SkillRequest request) {
        if (request == null) {
            throw new BadRequestException("Request not found");
        }
        if (request.getSkillName() == null || request.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters");
        }
        return skillRequestRepository.save(request);
    }
    
    @Override
    public SkillRequest getRequest(Long id) {
        return skillRequestRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
    }
    
    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return skillRequestRepository.findByUserId(userId);
    }
    
    @Override
    public List<SkillRequest> getRequestsByCategory(Long categoryId) {
        return skillRequestRepository.findBySkillCategoryId(categoryId);
    }
    
    @Override
    public List<SkillRequest> getOpenRequests() {
        return skillRequestRepository.findByStatus("OPEN");
    }
    
    @Override
    public List<SkillRequest> getAllRequests() {
        return skillRequestRepository.findAll();
    }
}