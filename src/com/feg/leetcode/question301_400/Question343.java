package com.feg.leetcode.question301_400;

/**
 * @author Feg
 * @version 1.0
 */
public class Question343 {
    public int integerBreak(int n) {
        // 定义dpTable数组，每一项表示数字n的最大拆分积
        int[] dpTable = new int[n + 1];
        // 初始化，数字2的最大拆分积是1；
        dpTable[2] = 1;
        return dp(dpTable, n);
    }
    public int dp(int[] dpTable, int n){
        // 备忘录
        // 这里没有base case，因为每次向前移动一位，到2的位置就会停住
        if (dpTable[n] != 0) {
            return dpTable[n];
        }
        // 对于n拆分，从1开始，假设拆分为两个数字，一个i，一个n-i，则积有两种可能：
        //第一：直接相乘，第二，把n-i继续拆分，得到dp(n-i)的最大乘积，再乘以i。
        //然后比较这两个的最大值，需要注意的是对于每一个i都会有一个算出来的最大值，
        //最后再比较这些最大值的最大值，就是结果。
        for (int i = 1; i <= n/2; i++) {
            dpTable[n] = max(dpTable[n],i * (n-i), i* dp(dpTable,n-i));
        }
        return dpTable[n];
    }
    public int max(int num,int m,int n){
        return Math.max(num, Math.max(m, n));
    }
}
