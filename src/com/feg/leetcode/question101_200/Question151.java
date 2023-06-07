package com.feg.leetcode.question101_200;


/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/2 16:40
 * 反转字符串中的单词顺序，单词之间和字符串前后可能包含多余的空格
 */
public class Question151 {
    public String reverseWords(String s) {
        // 常规思路，1. 先去除空格
        int start = 0;
        int end = s.length() - 1;
        // 1.1 先去除前后的空格
        while (s.charAt(start) == ' '){
            start++;
        }
        while (s.charAt(end) == ' '){
            end--;
        }
        StringBuilder sb = new StringBuilder();
        // 1.2 去除中间的空格
        while (start <= end) {
            // 哪种情况下需要append？要么当前字符不是空格，要么是空格但前一个字符不是空格
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }
            start++;
        }
        // 2. 然后分割字符串
        String[] split = sb.toString().split(" ");
        sb = new StringBuilder();
        // 3. 倒序数组重组字符串
        for (int i = split.length - 1; i >= 0 ; i--) {
            sb.append(split[i]).append(" ");
        }
        // 注意末尾的空格
        return sb.substring(0, sb.length() - 1);
    }
}
