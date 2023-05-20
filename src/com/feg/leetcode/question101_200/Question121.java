package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 */
public class Question121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        // 定义dp数组，i表示第几天，j表示是否持有股票，分为0（未持有）和1（持有），
        //注意是否持有是看当前晚上的，也就是当前快过去的时候的状态。
        int[][] dpTable = new int[length][2];
        // 初始化dp数组
        dpTable[0][0] = 0;
        dpTable[0][1] = -prices[0];
        // 从左往右遍历
        for (int i = 1; i < length; i++) {
            dpTable[i][0] = Math.max(dpTable[i-1][0],dpTable[i-1][1] + prices[i]);
            dpTable[i][1] = Math.max(dpTable[i-1][1],-prices[i]);
        }
        // 返回需要的值
        return dpTable[length-1][0];
    }
}
