package com.feg.leetcode.question1_100;

/**
 * 不同路径
 * @author Feg
 * @version 1.0
 * 自己总结的动态规划的一些关键点：
 * 1.初始化dpTable的大小，一般要比题目中给出的边界大1；
 * 2.dp函数中的边界，控制递归的最后一个位置，很关键，决定了最后的结果是否有一个位置的误差
 * 3.状态方程，这反倒是最简单的了，一般就是前几项的结果推导一下；
 * 4.备忘录，记得使用备忘录减少计算；
 */
public class Question62 {
    public int uniquePaths(int m, int n) {
        // dp表，二维数组，每一项表示到达m，n位置的不同路径个数
        int[][] dpTable = new int[m][n];
        return dp(dpTable,m - 1,n - 1);
    }
    public int dp(int[][] dpTable,int m,int n){
        // 边界
        if (m <= 0 || n <= 0){
            return 1;
        }
        if (dpTable[m][n] != 0) {
            return dpTable[m][n];
        }
        // 状态方程
        dpTable[m][n] = dp(dpTable,m - 1,n) + dp(dpTable,m,n-1);
        return dpTable[m][n];
    }
}
