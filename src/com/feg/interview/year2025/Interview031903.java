package com.feg.interview.year2025;

/**
 * @author Feg
 * @createDate 2025/3/30 09:42
 * @description 买卖股票的最佳时机
 */
public class Interview031903 {
    
    /**
     * 常规做法，对于第i天之前卖出来说，最大收益是减去0到i天中的最小值，或者之前已经存在的收益最大值
     * @param prices 股票每天的价格
     * @return 这支股票的最大收益
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        // 当前位置之前的最小值
        int leftMin = prices[0];
        for (int p: prices) {
            result = Math.max(result, p - leftMin);
            // 更新最小值
            leftMin = Math.min(leftMin, p);
        }
        return result;
    }
}
