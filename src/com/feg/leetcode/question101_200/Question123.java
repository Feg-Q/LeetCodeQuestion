package leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 * 买卖股票问题3，直接从4的代码稍微改一下就行了，就把题目中给的k改成2。因为明确表示了只能进行2次交易
 */
public class Question123 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dpTable = new int[length][3][2];
        // 初始化j=0的情况,实际上可以删掉，因为里面的dpTable[i][0][1]根本用不到，而dpTable[i][0][0]默认就是0
        for (int i = 0; i < length; i++) {
            dpTable[i][0][0] = 0;
            dpTable[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 0) {
                    dpTable[i][j][0] = 0;
                    dpTable[i][j][1] = -prices[0];
                    continue;
                }
                dpTable[i][j][0] = Math.max(dpTable[i-1][j][0],dpTable[i-1][j][1] + prices[i]);
                dpTable[i][j][1] = Math.max(dpTable[i-1][j][1],dpTable[i-1][j-1][0] - prices[i]);
            }
        }
        return dpTable[length-1][2][0];
    }
}
