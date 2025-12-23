package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    @Autowired
    private SkillRequestService requestService;

    // Get all requests
    @GetMapping
    public ResponseEntity<List<SkillRequest>> getAllRequests() {
        List<SkillRequest> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Get request by ID
    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> getRequest(@PathVariable Long id) {
        SkillRequest request = requestService.getRequestById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + id));
        return ResponseEntity.ok(request);
    }

    // Get requests by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillRequest>> getRequestsByCategory(@PathVariable Long categoryId) {
        List<SkillRequest> requests = requestService.getRequestsByCategory(categoryId);
        return ResponseEntity.ok(requests);
    }

    // Create new request
    @PostMapping
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        SkillRequest created = requestService.createRequest(request);
        return ResponseEntity.ok(created);
    }

    // Update existing request
    @PutMapping("/{id}")
    public ResponseEntity<SkillRequest> updateRequest(@PathVariable Long id, @RequestBody SkillRequest request) {
        SkillRequest updated = requestService.updateRequest(id, request)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + id));
        return ResponseEntity.ok(updated);
    }

    // Delete request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        if (!requestService.deleteRequest(id)) {
            throw new ResourceNotFoundException("Request not found with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
