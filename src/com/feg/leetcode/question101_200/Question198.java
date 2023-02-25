package com.feg.leetcode.question101_200;

/**
 * 打家劫舍
 * @author Feg
 * @version 1.0
 */
public class Question198 {
    public int rob(int[] nums) {
        int length = nums.length;
        // dp[n]代表从第n项开始往后的最大收益
        int[] dpTable = new int[length + 2];
        // 初始化
        dpTable[length + 1] = 0;
        dpTable[length] = 0;
        // 这道题需要从后往前遍历，即从最后一间房屋开始，因为某一个房屋的最大收益取决于他之后的收益
        for (int i = length -1; i >= 0; i--) {
            dpTable[i] = Math.max(dpTable[i+1],nums[i] + dpTable[i+2]);
        }
        return dpTable[0];
    }
}
