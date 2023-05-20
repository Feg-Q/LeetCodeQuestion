package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 */
public class Question188 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        // 这里会有k很大而导致数组太大的情况，
        //实际上k的值超过某个值之后就没有约束作用了，即买入卖出需要两天，所以最多会有length/2次交易
        if (k > length / 2) {
            k = length / 2;
        }
        // 定义dp数组，很关键，数组中第一项表示第几天，第二项表示限制交易的次数，第三项表示当天是否持有股票，用0表示未持有，1表示持有
        int[][][] dpTable = new int[length][k][2];
        // 初始化数组
        // 这里初始化k = 0的情况，i等于0的情况在循环中由条件给出，k=0意味着不能进行交易，那么还要持有就是去最小值便于之后取两者最大值
        //实际上这里的k=0且持有的情况后面用不到，递推公式中永远不会出现这一项，
        for (int i = 0; i < length; i++) {
            dpTable[i][0][1] = Integer.MIN_VALUE;
            dpTable[i][0][0] = 0;
        }
        for (int i = 0; i < length; i++) {
            // 遍历k，实际上这里正序或者倒序都可以，因为每一个值都只用到了正上方那一列的值，只要保证是从上往下遍历就行
            for (int j = 1; j <= k ; j++) {
                // 处理特殊值，在这里判断i=0的情况就可以省去prices[i]的偏移量。
                if (i == 0){
                    dpTable[i][j][0] = 0;
                    dpTable[i][j][1] = -prices[i];
                    continue;
                }
                // 对于每一天，有两种状态，持有或者不持有，
                //如果持有，有两种可能，昨天就持有，或者今天刚买
                dpTable[i][j][1] = Math.max(dpTable[i-1][j][1],dpTable[i-1][j-1][0] - prices[i]);
                //如果未持有，有两种可能，今天卖了，或者昨天就未持有
                dpTable[i][j][0] = Math.max(dpTable[i-1][j][1] + prices[i],dpTable[i-1][j][0]);
            }
        }
        return dpTable[length-1][k][0];
    }
}
