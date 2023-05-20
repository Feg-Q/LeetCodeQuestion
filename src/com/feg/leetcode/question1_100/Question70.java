package com.feg.leetcode.question1_100;

/**
 * 爬楼梯问题（动态规划）
 * @author Feg
 * @version 1.0
 */
public class Question70 {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        // 定义dp数组，每一项是爬n阶楼梯有dpTable[n]种方式
        int[] dpTable = new int[n + 1];
        dpTable[1] = 1;
        dpTable[2] = 2;
        return dp(dpTable,n);
    }
    public int dp(int[] dpTable,int n){
        if (dpTable[n] != 0){
            return dpTable[n];
        }
        dpTable[n] = dp(dpTable,n -1) + dp(dpTable,n - 2);
        return dpTable[n];
    }

    public static void main(String[] args) {
        int i = new Question70().climbStairs(5);
        System.out.println(i);
    }
}
