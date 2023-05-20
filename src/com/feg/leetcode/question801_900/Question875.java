package com.feg.leetcode.question801_900;

import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 * 二分搜索的拓展问题，找出自变量x、关于x的函数f(x)、目标值target。
 * 本题中自变量是每小时吃的香蕉的个数，函数f是按照这个个数所需要的总时间，目标值是限定时间H。
 */
public class Question875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        // right赋一个最大值，然后往中间查找
        int right = 1000000000 + 1;
        // 优化一下，如果数组的数据很少，则找出数组中的最大值更快
        if (piles.length < 20) {
            right = Arrays.stream(piles).max().getAsInt();
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (getAllHours(piles, mid) <= h){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // x的定义域是1到数组中的最大值
        return left;
    }
    public int getAllHours(int[] piles,int x){
        int allHours = 0;
        for (int i = 0; i < piles.length; i++) {
            allHours += piles[i] / x;//吃完这一堆香蕉需要的时间，有偏差。
            // 补足偏差
            if (piles[i] % x > 0){
                allHours++;
            }
        }
        return allHours;
    }
}
