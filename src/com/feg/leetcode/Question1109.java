package com.feg.leetcode;

/**
 * @author Feg
 * @version 1.0
 * 标准的差分数组技巧，需要注意的是给出的编号是1-5，而数组下标从0开始。
 */
public class Question1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int k = booking[2];
            diff[i-1] += k;
            if (j<n){
                diff[j] -= k;
            }
        }
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] + diff[i];
        }
        return result;
    }
}
