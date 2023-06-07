package com.feg.leetcode.question501_600;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/31 20:21
 */
public class Question541 {
    public static void main(String[] args) {
        System.out.println(new Question541().reverseStr("a",1));
    }
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        // 暂存原字符串长度值
        int length = s.length();
        // 循环操作
        for (int i = 0;i < length; i += 2*k) {
            if (i + 2 * k <= length) {
                result.append(reverse(s.substring(i,i + 2 * k),k));
            } else {
                if (i + k <= length){
                    result.append(reverse(s.substring(i,length), k));
                } else {
                    result.append(reverse(s.substring(i,length),length - i));
                }
            }
        }
        return result.toString();
    }
    // 翻转字符串s的前k个字符
    public String reverse(String s,int k){
        StringBuilder stringBuilder = new StringBuilder();
        String substring = s.substring(0, k);
        char[] chars = substring.toCharArray();
        for (int i = substring.length() - 1; i >= 0 ; i--) {
            stringBuilder.append(chars[i]);
        }
        stringBuilder.append(s,k,s.length());
        return stringBuilder.toString();
    }
}
