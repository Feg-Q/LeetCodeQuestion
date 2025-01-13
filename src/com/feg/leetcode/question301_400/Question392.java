package com.feg.leetcode.question301_400;

/**
 * @author Feg
 * @createDate 2025/1/13 20:36
 * @description 判断字符串t是否是字符串s的子序列
 */
public class Question392 {
    
    public boolean isSubsequence(String s, String t) {
        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()) {
            if (s.charAt(s1) == t.charAt(t1)) {
                s1++;
            }
            t1++;
        }
        return s1 == s.length();
    }
}
