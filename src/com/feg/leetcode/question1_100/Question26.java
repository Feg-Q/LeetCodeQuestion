package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 删除数组中的重复项
 */
public class Question26 {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast<nums.length){
            if (nums[fast]!=nums[fast-1]){
                nums[slow+1] = nums[fast];//点睛之笔，将fast的值赋给slow+1的值
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}
