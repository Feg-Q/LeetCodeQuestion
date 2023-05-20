package leetcode.question501_600;

/**
 * @author Feg
 * @version 1.0
 * 不看答案自己写的时候有两个地方出问题了，导致最后的结果不对，
 * 一是数组初始化，二是状态转移方程
 */
public class Question518 {
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[][] dpTable = new int[length + 1][amount + 1];
        for (int i = 0; i <= length; i++) {
            dpTable[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i-1] < 0) {
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-coins[i-1]];
                }
            }
        }
        return dpTable[length][amount];
    }
}
