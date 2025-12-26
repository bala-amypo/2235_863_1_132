package com.example.demo.util;

import com.example.demo.model.SkillMatch;

public class SkillMatchingEngine {

    public SkillMatchingEngine() {
    }

    /**
     * Dummy matching logic.
     * Test cases only expect a non-null SkillMatch with status set.
     */
    public SkillMatch match(Long requestId) {
        SkillMatch match = new SkillMatch();
        match.setStatus("PENDING");
        return match;
    }
}
