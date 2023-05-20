package com.feg.leetcode.question301_400;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 零钱兑换，完全背包问题
 * @author Feg
 * @version 1.0
 */
public class Question322 {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable,Integer.MAX_VALUE);
        dpTable[0] = 0;
        for (int i = 0; i < length; i++) { // 遍历硬币个数，正序就行
            // 完全背包的区别就是比较最小值的时候比较的是当前行的前面的值，因此要先计算前面的，即正序遍历
            for (int j = coins[i]; j <= amount; j++) {
                if (dpTable[j-coins[i]] != Integer.MAX_VALUE) {
                    dpTable[j] = Math.min(dpTable[j],dpTable[j-coins[i]] + 1);
                }
            }
        }
        return dpTable[amount] == Integer.MAX_VALUE ? -1 :dpTable[amount];
    }

    // 方法二：用二维dp数组来解决，但奇怪的是一直有过不去的数据，理论上来说做好了转换了，
    //比如[186,419,83,408]，6249.这个示例，
    //理论上来说二维数组要比一维数组的时间复杂度高的多，因为还要全遍历赋值，空间复杂度也搞了很多，理解上稍微好理解一点。

    // 卧槽！我被ai震撼了，这个二维数组的方式我一直不知道问题在哪里，然后让AI给出二维数组的题解后，我一下就明白了，而且AI给的代码直接AC
    //其一是初始化数组的地方错了，我原本是将除了第一列外的元素都初始化成了最大值，
    //但AI只初始化了第一行，我一想明白了，一维数组的时候初始化了0之后的所有元素，相当于初始化了第一行。
    // 第二条是递推方程那里，就不需要再判断dpTable[i][j - coins[i - 1]]的值是不是最大值了，因为即便是最大值，也会在加一后比dpTable[i-1][j]小。
    public int coinChange1(int[] coins, int amount) {
        int length = coins.length;
        int[][] dpTable = new int[length + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dpTable[0][i] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= amount; j++) {
            for (int i = 1; i <= length; i++) {
                if (j < coins[i-1]) {
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = Math.min(dpTable[i-1][j], dpTable[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dpTable[length][amount] == Integer.MAX_VALUE ? -1 :dpTable[length][amount];
    }
}
