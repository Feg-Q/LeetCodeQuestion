package com.feg.interview;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/8 9:16
 * 给定一个字符串 s，实现一个函数来判断其中是否包含重复字符，如果包含则返回是否包含和其最长长度。要求：
 * 只考虑字母和数字字符。
 * 字母区分大小写，请区分大小写。
 * 例如，对于字符串 "leetcode"，函数应该返回:true,2。因为 e 这个字符都出现了多次。而对于字符串 "abc123"，函数应该返回 false,0，因为没有重复字符。
 */
public class Question7_8 {

    public void maxConsecutiveRepeatedCharLength(String s) {
        int resLength = 0;
        char resChar = ' ';
        int tempLength = 1;
        char tempChar = s.charAt(0);
        // 遍历每一个字符
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // 如果当前字符等于前一个字符，则意味着仍处于连续重复段内，则更新结果长度和字符
            if (curChar == tempChar) {
                tempLength++;
                resChar = tempLength > resLength ? tempChar : resChar;
                resLength = Math.max(resLength, tempLength);
            } else {
                // 当前字符和上一个不同，则重置临时字符和长度
                tempLength = 1;
                tempChar = curChar;
            }
        }
        // 只有在有重复字符的时候才会修改结果字符的值，如果最后没有修改，则意味着返回false
        System.out.println(resChar == ' ' ? false : resLength);
    }
}
