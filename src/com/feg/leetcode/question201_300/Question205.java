package com.feg.leetcode.question201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feg
 * @createDate 2025/2/14 12:30
 * @description 判断异构字符
 */
public class Question205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sCharMap = new HashMap<>();
        Map<Character, Character> tCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            Character sMapping = sCharMap.get(sChar);
            Character tMapping = tCharMap.get(tChar);
            if (sMapping != null && sMapping != tChar) {
                return false;
            }
            if (tMapping != null && tMapping != sChar) {
                return false;
            }
            sCharMap.put(sChar, tChar);
            tCharMap.put(tChar, sChar);
        }
        return true;
    }
}
