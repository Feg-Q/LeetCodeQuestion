package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 删除数组中的指定数值（快慢双指针）
 */
public class Question27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if (nums[fast] != val){
                if (fast!=slow) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
