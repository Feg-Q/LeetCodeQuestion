package com.feg.leetcode.question2401_2500;

/**
 * @author Feg
 * @createDate 2024/9/19 22:04
 * @description
 */
public class Question2414 {
    public int longestContinuousSubstring(String s) {
        int left = 0;
        int right = 1;
        int maxLength = 0;
        while (right < s.length()) {
            if (s.charAt(right - 1) + 1 == s.charAt(right)) {
                right++;
            } else {
                // 不连续了
                maxLength = Math.max(maxLength, right - left);
                left = right;
                right++;
            }
        }
        if (right == s.length()) {
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
