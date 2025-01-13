package com.feg.leetcode.question1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @createDate 2024/12/7 10:32
 * @description 字母异位词集合
 */
public class Question49 {
    
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        
        for (String str : strs) {
            String sortedStr = str.chars()
                    .mapToObj(c -> (char) c)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            List<String> valueList = res.get(sortedStr) == null ? new ArrayList<>() : res.get(sortedStr);
            valueList.add(str);
            res.put(sortedStr, valueList);
        }
        return new ArrayList<>(res.values());
    }
}
