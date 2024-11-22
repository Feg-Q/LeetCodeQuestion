package com.feg.leetcode.question101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/11/21 08:32
 * @description
 */
public class Question131 {

    public static void main(String[] args) {
        System.out.println(new Question131().partition("aabcbcc"));
    }
    
    List<String> res = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(chars, 0, stringBuilder);
        return result;
    }
    
    public void dfs(char[] chars, int index, StringBuilder stringBuilder) {
        if (index == chars.length) {
            if (lengthChar(res) == chars.length) {
                result.add(new ArrayList<>(res));
            }
            return;
        }
        StringBuilder append = stringBuilder.append(chars[index]);
        boolean palindrome = isPalindrome(append.toString());
        // 如果是回文串，有两个选择，1.下一个重新开始计算；2.不作为答案，继续往后
        if (palindrome) {
            // 记录这个回文串
            res.add(append.toString());
            dfs(chars, index + 1, new StringBuilder());
            res.remove(res.size() - 1);
        }
        dfs(chars, index + 1, stringBuilder);
    }
    
    public boolean isPalindrome(String s) {
        if ("".equals(s)) return false;
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
    
    public int lengthChar(List<String> list) {
        int res = 0;
        for (String s : list) {
            res += s.length();
        }
        return res;
    }
}
