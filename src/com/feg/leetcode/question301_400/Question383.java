package com.feg.leetcode.question301_400;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/31 19:14
 * 赎金信，其实就是判断两个字符串的字符出现的频次是否相等
 */
public class Question383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = true;
        for (char c : magazine.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int integer = map.getOrDefault(c, 0);
            integer--;
            if (integer < 0){
                flag = false;
                break;
            }
            map.put(c,integer);
        }
        return flag;
    }
}
