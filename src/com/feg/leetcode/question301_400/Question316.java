package com.feg.leetcode.question301_400;

import java.util.Stack;

/**
 * 单调栈问题
 * 字符串去重，要求去重后顺序不变且字典序最小
 * @author Feg
 * @version 1.0
 */
public class Question316 {
    public String removeDuplicateLetters(String s) {
        // 栈用于记录去重后的字符。
        Stack<Character> stack = new Stack<>();
        // 布尔数组用于记录字符是否存在于栈中。
        boolean[] isHas = new boolean[200];
        // 维护一个int数组，用于记录每个字符出现过几次
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        // 遍历
        for (char c : s.toCharArray()) {
            count[c]--;
            // 如果字符已经存在于栈中，则不添加
            if (isHas[c]) {
                continue;
            }
            // v1否则添加到栈，并把布尔值设置成true。
            // v2用单调栈实现入栈的字符按字典序排列
            // v3这一步很关键，每次要将一个栈顶的大于当前字符的字符移出栈的时候，就判断这个字符后面还有没有出现，
            // 即这个字符的计数不为零，如果为零，则表明这个字符已经就剩这一个了，即便不是字典序也不能移出了
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 将移除的字符对应的布尔值设置为false。
                isHas[stack.pop()] = false;
            }
            stack.push(c);
            isHas[c] = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.reverse().toString();
    }
}
