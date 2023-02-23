package com.feg.leetcode.question701_800;

/**
 * 上台阶的最小花费（动态规划）
 * @author Feg
 * @version 1.0
 */
public class Question746 {
    public int minCostClimbingStairs(int[] cost) {
        // 给定的数组的长度就是台阶的个数，上到楼顶就是到长度+1的位置
        int length = cost.length;
        // 题目中要求length的值必定大于1，所以这一步判断没有必要。
//        if (length == 1) {
//            return 0;
//        }
        // dpTable的定义，第n项是表示上到n这个位置需要的最小花费
        int[] dpTable = new int[length + 1];
        return dp(cost, dpTable, length);
    }
    public int dp(int[] cost,int[] dpTable,int n){
        // 边界
        if (n <= 1) {
            return 0;
        }
        // 解决重叠子问题
        if (dpTable[n] != 0){
            return dpTable[n];
        }
        // 状态转移
        dpTable[n] = Math.min(dp(cost,dpTable,n-1) + cost[n-1] , dp(cost,dpTable,n-2) + cost[n-2]);
        return dpTable[n];
    }

}
