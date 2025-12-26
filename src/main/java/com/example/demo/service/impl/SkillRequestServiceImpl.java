package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository repository;

    public SkillRequestServiceImpl(SkillRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return repository.save(request);
    }

    @Override
    public Optional<SkillRequest> getRequestById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SkillRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public List<SkillRequest> getRequestsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public SkillRequest updateRequest(Long id, SkillRequest request) {
        request.setId(id);
        return repository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
