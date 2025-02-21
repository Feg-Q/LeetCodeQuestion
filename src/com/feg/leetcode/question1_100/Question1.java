package com.feg.leetcode.question1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/30 12:30
 * 两数之和
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sum[0] = i;
                    sum[1] = j;
                }
            }
        }
        return sum;
    }

    /**
     * 解法2
     * 关键是通过哈希表记录遍历过的数字和其下标，这样在遍历后面数字的时候，可以快速找到满足target - num的数字，和其下标
     * 因为一个数字必定匹配一个数字符合要求，因此碰到第一个数字的时候虽然判断是空，但是碰到第二个数字的时候一定可以找到
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; ; i++) {
            int num = nums[i];
            if (idx.containsKey(target - num)) {
                return new int[]{idx.get(target - num), i};
            }
            idx.put(num, i);
        }
    }
}
