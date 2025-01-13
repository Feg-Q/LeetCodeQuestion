package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @createDate 2025/1/9 15:54
 * @description
 */
public class Question169 {
    
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count++;
                }
            }
        }
        return res;
    }
}
