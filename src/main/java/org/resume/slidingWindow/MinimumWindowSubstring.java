package org.resume.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public MinimumWindowSubstring(String s, String t) {
        System.out.println(minWindow(s,t));
    }

    private String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> characterCount = new HashMap<>();
        HashMap<Character, Integer> requiredCount = new HashMap<>();

        // Initialize requiredCount with the characters in t and their counts
        for (char c : t.toCharArray()) {
            requiredCount.put(c, requiredCount.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int requiredChars = t.length();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Update characterCount
            characterCount.put(rightChar, characterCount.getOrDefault(rightChar, 0) + 1);

            // Check if the current character is in requiredCount and satisfies the requirement
            if (requiredCount.containsKey(rightChar) && characterCount.get(rightChar) <= requiredCount.get(rightChar)) {
                requiredChars--;
            }

            // Try to minimize the window by moving the left pointer
            while (requiredChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (requiredCount.containsKey(leftChar) && characterCount.get(leftChar) <= requiredCount.get(leftChar)) {
                    requiredChars++;
                }

                characterCount.put(leftChar, characterCount.get(leftChar) - 1);
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }

}
