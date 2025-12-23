package com.example.demo.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class to match users based on skills.
 */
public class SkillMatchingEngine {

    /**
     * Find users who have overlapping skills with the required skills.
     *
     * @param requiredSkills Set of required skills
     * @param userSkillsMap  Map of username -> Set of user skills
     * @return Map of username -> number of matching skills (sorted descending)
     */
    public static Map<String, Integer> matchSkills(Set<String> requiredSkills, Map<String, Set<String>> userSkillsMap) {
        Map<String, Integer> matchedUsers = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : userSkillsMap.entrySet()) {
            String username = entry.getKey();
            Set<String> skills = entry.getValue();

            // Count how many skills match
            long matchCount = skills.stream()
                    .filter(requiredSkills::contains)
                    .count();

            if (matchCount > 0) {
                matchedUsers.put(username, (int) matchCount);
            }
        }

        // Sort by number of matching skills in descending order
        return matchedUsers.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    /**
     * Example usage
     */
    public static void main(String[] args) {
        Set<String> requiredSkills = Set.of("Java", "Spring Boot", "SQL");

        Map<String, Set<String>> users = new HashMap<>();
        users.put("Alice", Set.of("Java", "Python"));
        users.put("Bob", Set.of("Java", "Spring Boot", "SQL"));
        users.put("Charlie", Set.of("HTML", "CSS"));

        Map<String, Integer> matches = matchSkills(requiredSkills, users);
        System.out.println("Matched Users: " + matches);
        // Output: {Bob=3, Alice=1}
    }
}
