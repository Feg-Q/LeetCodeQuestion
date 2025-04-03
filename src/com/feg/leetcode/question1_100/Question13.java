package com.feg.leetcode.question1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feg
 * @version 1.0
 * @description 罗马数字转数字
 */
public class Question13 {
    
    public int romanToInt(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            int num = map.get(charArray[i]);
            int rightNum = (i + 1) == s.length() ? 0 : map.get(charArray[i + 1]);
            if (num >= rightNum) {
                result += num;
            } else {
                result += (rightNum - num);
                i++;
            }
        }
        return result;
    }
}
