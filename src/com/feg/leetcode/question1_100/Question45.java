package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/3/31 16:44
 * @description 跳跃游戏2
 */
public class Question45 {

    public int jump(int[] nums) {
        int result = 0;
        int curRight = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, i + nums[i]);
            if (i == curRight) {
                curRight = right;
                result++;
            }
        }
        return result;
    }
}
