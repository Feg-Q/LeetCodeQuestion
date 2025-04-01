package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/3/31 16:32
 * @description 跳跃游戏
 */
public class Question55 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightIndex = 0;
        int leftIndex = 0;
        while (leftIndex < length && leftIndex <= rightIndex) {
            int num = nums[leftIndex];
            rightIndex = Math.max(rightIndex, leftIndex + num);
            if (rightIndex >= length - 1) {
                return true;
            }
            leftIndex++;
        }
        return leftIndex == length;
    }
}
