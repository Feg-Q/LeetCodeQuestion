package com.feg.leetcode.question1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Feg
 * @createDate 2024/11/19 08:57
 * @description
 */
public class Question17 {
    
    List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> charMap = new HashMap<>();
        charMap.put('2', new char[]{'a', 'b', 'c'});
        charMap.put('3', new char[]{'d', 'e', 'f'});
        charMap.put('4', new char[]{'g', 'h', 'i'});
        charMap.put('5', new char[]{'j', 'k', 'l'});
        charMap.put('6', new char[]{'m', 'n', 'o'});
        charMap.put('7', new char[]{'p', 'q', 'r', 's'});
        charMap.put('8', new char[]{'t', 'u', 'v'});
        charMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] input = digits.toCharArray();
        dfs(charMap, input, 0, new StringBuilder());
        return res;
    }
    
    public void dfs(Map<Character, char[]> charMap, char[] input, int i, StringBuilder builder) {
        if (i == input.length) {
            if (!builder.toString().isEmpty()) {
                res.add(builder.toString());
            }
            return;
        }
        char c = input[i];
        char[] chars = charMap.get(c);
        for (char aChar : chars) {
            builder.append(aChar);
            dfs(charMap, input, i + 1, builder);
            builder.delete(i, builder.length());
        }
    }
}
