package leetcode.question501_600;

import java.util.Arrays;

/**
 * 斐波那契数列
 * @author Feg
 * @version 1.0
 */
public class Question509 {
    // 递归解法
    int[] dpTable;
    public int fib(int n) {
        dpTable = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dpTable,-1);
        }
        return dp(n);
    }
    public int dp(int num) {
        if (num == 1){
            return 1;
        }
        if (num == 0){
            return 0;
        }
        if (dpTable[num] != -1){
            return dpTable[num];
        }
        dpTable[num] = dp(num -1) + dp(num -2);
        return dpTable[num];
    }
    // 递推解法
    public int fib2(int n){
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // 还可以优化空间使用，即每次需要计算当前i位置的值的时候，只需要计算i - 1和i - 2位置的值，也就是说每次只需要占用三个值，
    //则可以用a，b，c三个值依次计算覆盖即可。
}
