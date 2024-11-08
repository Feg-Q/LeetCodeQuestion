package com.feg.leetcode.question3201_3300;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2024/11/7 19:11
 * @description LeetCode每日一题 2024.11.7
 * 给一个数组，和一个正整数，然后求出这个数组的所有大小为K的子数组的能量值
 * 能量值定义为如果数组连续，则是最大的那个，如果不连续，则是-1
 */
public class Question3255 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,5,6};
        int k = 2;
        System.out.println(Arrays.toString(new Question3255().resultsArray(nums, k)));
    }
    
    public int[] resultsArray(int[] nums, int k) {
        int[] results = new int[nums.length - k + 1];
        Arrays.fill(results, -1);
        int incr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                incr = 1;
            } else if (nums[i] == nums[i - 1] + 1) {
                incr++;
            } else {
                incr = 1;
            }
            if (incr >= k) {
                results[i - k + 1] = nums[i];
            }
        }
        return results;
    }
}
