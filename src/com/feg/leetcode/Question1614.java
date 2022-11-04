package com.feg.leetcode;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class Question1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for(char c: chars){
            if(c == '('){
                stack.add(c);
            } else if(c == ')'){
                depth = Math.max(depth,stack.size());
                stack.pop();
            }
        }
        return depth;
    }
}
