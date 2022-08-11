package com.feg.leetcode.question1_100;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class Question20 {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            char temp = array[i];
            switch (temp){
                case '(':
                    nums[i] = 1;
                    break;
                case ')':
                    nums[i] = -1;
                    break;
                case '[':
                    nums[i] = 2;
                    break;
                case ']':
                    nums[i] = -2;
                    break;
                case '{':
                    nums[i] = 3;
                    break;
                case '}':
                    nums[i] = -3;
                    break;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()){
                stack.add(nums[i]);
            }else {
                if ((stack.peek() + nums[i] == 0)&&nums[i]<0) {
                    stack.pop();
                } else {
                    stack.add(nums[i]);
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
