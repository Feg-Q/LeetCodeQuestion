package com.feg.leetcode.question3201_3300;

/**
 * @author Feg
 * @createDate 2024/11/15 08:29
 * @description 
 * 第一眼就是暴力解法，先从行的角度算出一个翻转次数，再从列的角度计算，然后求最小值
 * 结果题解也是这种思路
 */
public class Question3239 {

    public static void main(String[] args) {
        int[][] grid = {{0,1},{0,1},{0,0}};
        new Question3239().minFlips(grid);
    }
    
    public int minFlips(int[][] grid) {
        int resultLine = 0;
        // 行回文
        int columnLength = grid.length;
        int lineLength = grid[0].length;
        for (int i = 0; i < columnLength; i++) {
            int left = 0;
            int right = lineLength - 1;
            while (left < right) {
                if (grid[i][left] != grid[i][right]) {
                    resultLine++;
                }
                left++;
                right--;
            }
        }
        int resultColumn = 0;
        for (int i = 0; i < lineLength; i++) {
            int left = 0;
            int right = columnLength - 1;
            while (left < right) {
                if (grid[left][i] != grid[right][i]) {
                    resultColumn++;
                }
                left++;
                right--;
            }
        }
        return Math.min(resultLine, resultColumn);
    }
}
