package com.feg.leetcode.question401_500;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class Question496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 创建一个map用来存储数组2的值和其之后最近最大的一个元素的映射
        HashMap<Integer, Integer> map = new HashMap<>();
        // 两个数组的长度
        int length1 = nums2.length;
        int length2 = nums2.length;
        // 创建一个栈，用来模拟单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = length1 - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[length2];
        for (int i = 0; i < length2; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
