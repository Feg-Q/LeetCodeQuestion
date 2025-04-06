package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/4/6 18:19
 * @description 最后一个单词的长度
 */
public class Question58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = 0;
        boolean letter = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) {
                if (letter) {
                    length++;
                } else {
                    letter = true;
                    length = 1;
                }
            } else {
                if (letter) {
                    letter = false;
                    length = 0;
                }
            }
        }
        return length;
    }
    
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
