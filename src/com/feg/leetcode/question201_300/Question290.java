package com.feg.leetcode.question201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feg
 * @createDate 2025/2/20 19:19
 * @description 单词规律
 * @result 和第205个题目一模一样，直接用双Map记录双映射关系即可，注意两者的长度不一致的情况
 */
public class Question290 {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        Map<Character, String> sCharMap = new HashMap<>();
        Map<String, Character> tCharMap = new HashMap<>();
        int i = 0;
        for (; i < pattern.length(); i++) {
            if (i >= array.length) {
                return false;
            }
            char patternChar = pattern.charAt(i);
            String ss = array[i];
            String sMapping = sCharMap.get(patternChar);
            Character tMapping = tCharMap.get(ss);
            if (sMapping != null && !sMapping.equals(ss)) {
                return false;
            }
            if (tMapping != null && tMapping != patternChar) {
                return false;
            }
            sCharMap.put(patternChar, ss);
            tCharMap.put(ss, patternChar);
        }
        return i == array.length;
    }
}
