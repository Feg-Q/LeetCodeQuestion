package com.feg.剑指offerll;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/6 22:21
 */
public class Question58_II {
    public String reverseLeftWords(String s, int n) {
        String s1 = reverseString(s.substring(0, n));
        String s2 = reverseString(s.substring(n));
        return reverseString(s1 + s2);
    }
    public String reverseString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
