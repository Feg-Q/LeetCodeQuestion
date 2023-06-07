package com.feg.leetcode.question401_500;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/31 19:07
 * 四数相加，相比于两数之和以及三数之和要简单，毕竟不用去重
 */
public class Question454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                result += map.getOrDefault(- i - j,0);
            }
        }
        return result;
    }
}
