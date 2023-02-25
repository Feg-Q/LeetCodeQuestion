package com.feg.leetcode.question401_500;

/**
 * @author Feg
 * @version 1.0
 */
public class Question474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dpTable = new int[m + 1][n + 1];
        for (String str : strs) {
            // 统计当前元素包含的0和1的个数
            int x = 0;
            int y = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    y++;
                } else {
                    x++;
                }
            }
            // 原本是三维数组，每一个元素、m、n，但这里压缩了，因此需要倒序遍历，因为当前值需要用到上一层的前面的数据，
            // 而上一层前面的数据就在这一层的前面还没有遍历到的地方。
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y; j--) {
                    // 这个递推公式没有想到
                    //在背包限制为m，n的时候，当前元素是否能放进去，如果不能，那背包里的个数还是前一个元素时的个数
                    //如果能放进去，那么元素个数就是除了当前元素之外的空间还能放进去的最大元素个数加上这一个
                    dpTable[i][j] = Math.max(dpTable[i][j],dpTable[i-x][j-y] + 1);
                }
            }
        }
        return dpTable[m][n];
    }
}
