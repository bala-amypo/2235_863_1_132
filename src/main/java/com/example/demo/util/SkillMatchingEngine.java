package com.example.demo.util;

import com.example.demo.model.User;
import java.util.List;

public class SkillMatchingEngine {

    /**
     * Calculate match score between two users based on their skills.
     * @param user1 First user
     * @param user2 Second user
     * @return match score as integer
     */
    public int calculateMatchScore(User user1, User user2) {
        int score = 0;

        // Example: assuming User has skillLevel as String, convert to int
        try {
            int skillLevel1 = Integer.parseInt(user1.getSkillLevel());
            int skillLevel2 = Integer.parseInt(user2.getSkillLevel());

            // Simple scoring logic (can be replaced with your own algorithm)
            score = 100 - Math.abs(skillLevel1 - skillLevel2);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing skill level: " + e.getMessage());
        }

        return score;
    }

    /**
     * Find the best match from a list of users for a given user.
     * @param targetUser the user to match
     * @param allUsers list of users to compare with
     * @return user with highest match score
     */
    public User findBestMatch(User targetUser, List<User> allUsers) {
        User bestMatch = null;
        int highestScore = -1;

        for (User user : allUsers) {
            if (user.getId().equals(targetUser.getId())) continue; // skip self

            int score = calculateMatchScore(targetUser, user);
            if (score > highestScore) {
                highestScore = score;
                bestMatch = user;
            }
        }

        return bestMatch;
    }
}
