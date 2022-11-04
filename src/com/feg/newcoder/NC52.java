package com.feg.newcoder;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class NC52 {
    public boolean isValid (String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: chars){
            if(c == '(' || c == '{' || c== '['){
                stack.add(c);
            }else{
                char b = isA(c);
                if(!stack.isEmpty() && stack.peek() == b){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public char isA(char c){
        if(c == ')'){
            return '(';
        } else if(c == '}'){
            return '{';
        } else {
            return '[';
        }
    }
}
