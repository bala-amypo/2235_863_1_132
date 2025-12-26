package com.example.barter.controller;

import com.example.barter.model.SkillRequest;
import com.example.barter.service.SkillRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class SkillRequestController {

    private final SkillRequestService requestService;

    public SkillRequestController(SkillRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public SkillRequest create(@RequestBody SkillRequest request) {
        return requestService.createRequest(request);
    }

    @GetMapping("/{id}")
    public SkillRequest get(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @GetMapping
    public List<SkillRequest> all() {
        return requestService.getAllRequests();
    }
}
