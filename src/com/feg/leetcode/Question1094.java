package com.feg.leetcode;

/**
 * @author Feg
 * @version 1.0
 * 差分数组的技巧
 * 拼车
 */
public class Question1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int count = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;//在第j站就下车意味着这一站可以再多一个人
            diff[i] += count;
            diff[j] -= count;
        }
        int[] result = new int[1001];
        result[0] = diff[0];
        //构造每一站的人数
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        //遍历判断是否有一站人数超过限定值
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}