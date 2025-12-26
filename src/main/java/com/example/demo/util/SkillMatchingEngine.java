package com.example.demo.util;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class SkillMatchingEngine {

    /**
     * Checks if two users are a match based on skill level.
     * Here, a match is defined as having skill levels within 1 point difference.
     */
    public static boolean isMatch(User user1, User user2) {
        int level1 = user1.getSkillLevel();
        int level2 = user2.getSkillLevel();
        return Math.abs(level1 - level2) <= 1;
    }

    /**
     * Finds all users from a list that match the given user based on skill level.
     */
    public static List<User> findMatches(User user, List<User> allUsers) {
        List<User> matches = new ArrayList<>();
        for (User otherUser : allUsers) {
            if (!otherUser.equals(user) && isMatch(user, otherUser)) {
                matches.add(otherUser);
            }
        }
        return matches;
    }
}
