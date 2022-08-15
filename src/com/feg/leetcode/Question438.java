package com.feg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * 从s中找p的所有异位词，即p的所有排列。
 * 这道题和567题几乎一模一样，仅把存在改成了所有，只要找出一个后记录下来，然后继续遍历，就能找到所有结果。
 */
public class Question438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int count = 0;
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            Integer integer = needMap.get(c);
            needMap.put(c,(integer == null ? 1 : integer+1));
        }
        char[] chars = s.toCharArray();
        while (right<s.length()){
            char windowChar = chars[right];
            right++;
            if (needMap.containsKey(windowChar)){
                Integer windowInteger = windowMap.get(windowChar);
                windowMap.put(windowChar,(windowInteger == null ? 1 : windowInteger+1));
                if (windowMap.get(windowChar).equals(needMap.get(windowChar))){
                    count++;
                }
            }
            while (right - left >= p.length()){
                if (count == needMap.size()){
                    result.add(left);
                }
                char leftChar = chars[left];
                left++;
                if (needMap.containsKey(leftChar)){
                    if (windowMap.get(leftChar).equals(needMap.get(leftChar))){
                        count--;
                    }
                    windowMap.put(leftChar,windowMap.get(leftChar)-1);
                }
            }
        }
        return result;
    }
}
