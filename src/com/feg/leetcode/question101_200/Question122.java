package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 * from 188
 */
public class Question122 {
    public int maxProfit(int[] prices) {
        // 题中没有限制交易次数k，因此三维变成二维。
        int length = prices.length;
        // 定义dp数组，很关键，数组中第一项表示第几天，第二项表示限制交易的次数，第三项表示当天是否持有股票，用0表示未持有，1表示持有
        int[][] dpTable = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i == 0){
                dpTable[0][0] = 0;
                dpTable[0][1] = -prices[0];
                continue;
            }
            dpTable[i][0] = Math.max(dpTable[i-1][0],dpTable[i-1][1] + prices[i]);
            dpTable[i][1] = Math.max(dpTable[i-1][1],dpTable[i-1][0] - prices[i]);
        }
        return dpTable[length-1][0];
    }
}
