package com.feg.leetcode.question1501_1600;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2024/11/11 17:39
 * @description 切棍子
 * 题目描述：有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置，
 *  给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 *  每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
 *  对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）
 *  返回切割的最小成本。
 * 解析：刚看时看到第一想法是深度优先遍历，但是写起来比较麻烦，所以直接看了题解，才明白这是个很典型的动态规划问题
 *      首先从结果的最小就可以看出来，其次一次切割的最小成本，就是切割后左右两段的最小成本和，非常适用于动态规划
 */
public class Question1547 {
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int newLength = cuts.length + 2;
        int[][] memo = new int[newLength][newLength];
        // 构建一个新地取值数组
        int[] newCuts = new int[newLength];
        System.arraycopy(cuts, 0, newCuts, 1, newLength - 2);
        newCuts[newLength - 1] = n;
        return dp(0, newLength - 1, newCuts, memo);
    }

    /**
     * 定义为切割一段棍子的最小花费
     */
    public int dp(int i, int j, int[] cuts, int[][] memo) {
        // 边界情况
        if (i + 1 == j) {
            return 0;
        }
        // 记忆化处理
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dp(i, k, cuts, memo) + dp(k, j, cuts, memo));
        }
        memo[i][j] = res + cuts[j] - cuts[i];
        return memo[i][j];
    }
}
