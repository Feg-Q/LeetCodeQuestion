package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/4/6 18:33
 * @description 最长公共前缀
 */
public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        char c = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                // 对于第一个单词，先初始化字符c
                if (j == 0) {
                    c = str.charAt(i);
                }
                // 如果i的值已经大于这个单词的长度了，那就没必要继续比对下去了
                if (i >= str.length()) {
                    return result.toString();
                }
                // 如果比对之后不相等，那就可以结束了
                if (c != str.charAt(i)) {
                    return result.toString();
                }
                // 比对到最后一个单词的时候更新结果值
                if (j == strs.length - 1) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
