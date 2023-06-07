package com.feg.leetcode.question201_300;

import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/27 11:25
 * 判断两个字符串中的字符的个数是否相等
 */
public class Question242 {
    public boolean isAnagram(String s, String t) {
        int[] sum = new int[27];
        for (char c : s.toCharArray()) {
            sum[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            sum[c - 'a']--;
        }
        // 使用流操作判断数组中是否有元素的值不为0
        return Arrays.stream(sum).allMatch(value -> value == 0);
    }
}
