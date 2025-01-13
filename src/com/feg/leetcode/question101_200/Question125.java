package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @createDate 2025/1/13 12:53
 * @description 验证回文串
 */
public class Question125 {

    public static void main(String[] args) {
        System.out.println(new Question125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!isChar(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isChar(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
