package com.feg.leetcode;

import java.util.HashSet;

/**
 * @author Feg
 * @version 1.0
 * 我tm真是傻逼，咋会想的这么复杂，明明这么简单的逻辑，我TM还用集合，还用循环套循环，还判断套判断，我服了。
 */
public class Question1839 {

    public static void main(String[] args) {
        int i = new Question1839().longestBeautifulSubstring2("aaaaaaaaaaaaaaaaaaaaa");
        System.out.println(i);
    }

    public int longestBeautifulSubstring(String word) {
        int result = 0;
        char[] chars = word.toCharArray();

        int index = 0;
        for (; index < chars.length; index++) {
            //先找到第一个a出现的下标
            while (index < chars.length && chars[index] != 'a') {
                index++;
            }
            char c = 'a';
            // 从这里开始往后判断是否满足递增的条件
            int j = index + 1;
            while (j < chars.length && chars[j] == 'a') {
                j++;
            }
            HashSet<Character> list = new HashSet<>(4);
            list.add('e');
            list.add('i');
            list.add('o');
            list.add('u');
            while (j < chars.length) {
                char temp = chars[j];
                if (temp - c < 0) {
                    if (list.isEmpty()) {
                        // 如果此时子字符串包含了这五个字符，则记录长度
                        result = Math.max(j - index, result);
                    }
                    break;
                } else if (temp - c > 0) {
                    list.remove(temp);
                    c = temp;
                }
                if (j == chars.length - 1) {
                    if (list.isEmpty()) {
                        // 如果此时子字符串包含了这五个字符，则记录长度
                        result = Math.max(j - index + 1, result);
                    }
                    break;
                }
                j++;
            }
        }
        return result;
    }

    public int longestBeautifulSubstring2(String word) {
        int ans = 0, type = 1, len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) {
                len++; //更新当前字符串长度
            }
            if (word.charAt(i) > word.charAt(i - 1)) {
                type++; //更新当前字符种类
            }
            if (word.charAt(i) < word.charAt(i - 1)) {
                type = 1;
                len = 1;
            } //当前字符串不美丽，从当前字符重新开始
            if (type == 5) {
                ans = Math.max(ans, len);
            }  //更新最大字符串
        }
        return ans;
    }
}
