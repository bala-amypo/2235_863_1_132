package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    @Autowired
    private SkillRequestService requestService;

    @GetMapping
    public List<SkillRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PostMapping
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }
}
