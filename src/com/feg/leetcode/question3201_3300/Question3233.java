package com.feg.leetcode.question3201_3300;

/**
 * @author Feg
 * @createDate 2024/11/22 08:51
 * @description
 */
public class Question3233 {

    public static void main(String[] args) {
        System.out.println(new Question3233().nonSpecialCount(4, 16));
    }
    
    public int nonSpecialCount(int l, int r) {
        int right = (int) Math.sqrt(r);
        int[] flag = new int[right + 1];
        int res = r - l + 1;
        for (int i = 2; i <= right; i++) {
            if (flag[i] == 0) {
                // 首先此数的平方如果在l和r之间，则一定去除
                if (i * i >= l && i * i <= r) {
                    res--;
                }
                // 如果一个数是质数，则这个数乘以 2及往后的结果一定不是质数，用标记为1来标识不是质数
                for (int j = i * 2; j <= right; j += i) {
                    flag[j] = 1;
                }
            }
        }
        return res;
    }
}
