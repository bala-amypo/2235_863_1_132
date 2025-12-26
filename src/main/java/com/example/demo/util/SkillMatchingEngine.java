package com.example.demo.util;

import com.example.demo.model.User;
import java.util.ArrayList;
import java.util.List;

public class SkillMatchingEngine {

    public static boolean isMatch(User user1, User user2) {
        return Math.abs(user1.getSkillLevel() - user2.getSkillLevel()) <= 1;
    }

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
