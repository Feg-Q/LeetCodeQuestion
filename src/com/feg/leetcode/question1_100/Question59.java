package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 跟题解的答案一模一样怎么就超时了？我去，一个地方少了等号
 */
public class Question59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;
        while (num <= n*n){
            if (up <= down){
                for (int i = left; i <= right; i++) {
                    res[up][i] = num++;
                }
                up++;
            }
            if (right >= left){
                for (int i = up; i <= down; i++) {
                    res[i][right] = num++;
                }
                right--;
            }
            if (down >= up){
                for (int i = right; i >= left; i--) {
                    res[down][i] = num++;
                }
                down--;
            }
            if (left <= right){
                for (int i = down; i >= up; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
        }
        return res;
    }
}
