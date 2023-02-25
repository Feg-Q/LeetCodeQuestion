package com.feg.leetcode.question1001_1100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question1049 {
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dpTable = new int[length + 1][target + 1];
        // 初始化数组
        for (int i = stones[0]; i <= target; i++) {
            dpTable[1][i] = stones[0];
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < stones[i-1]) {
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i-1][j-stones[i-1]] + stones[i-1]);
                }
            }
        }
        return sum - dpTable[length][target] * 2;
    }
}
