package com.feg.leetcode;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class Question_offer03 {
    public int findRepeatNumber(int[] nums) {
//        //这个方法超出时间限制了;
//        Stack<Integer> stack = new Stack<>();
//        int i = 0;
//        while(true){
//            if(stack.contains(nums[i])){
//                break;
//            }else{
//                stack.add(nums[i]);
//            }
//            i++;
//        }
//        return nums[i];
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((++ints[nums[i]])>1){
                return nums[i];
            }
        }
        return -1;
    }
}
