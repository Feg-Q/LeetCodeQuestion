package com.feg.leetcode.question2501_2600;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2024/9/16 20:28
 * @description 给出一个数组，从中选择两个，满足其中一个大于另一个的2倍，则标记这两个元素，求最多可以标记多少个元素
 * 一眼看出贪心算法，首先排序，从最小的开始，则从一半位置往后找第一个大于这个值2倍的元素，标记，之后往后遍历即可
 */
public class Question2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int count = 0;
        int index = (nums.length + 1) / 2;
        int[] mark = new int[nums.length];
        // 对数组nums快速排序
        Arrays.sort(nums);
        // 遍历nums数组，对于i位置的元素，往前找第一个小于等于一半的元素，并标记
        for (int i = 0; i < nums.length; i++) {
            if (mark[i] == 1) {
                return count;
            }
            int temp = nums[i];
            while (index < nums.length && nums[index] < temp * 2) {
                index++;
            };
            // 如果index到达末尾，则之后都不会再有符合要求的了，因此直接返回
            if (index >= nums.length) {
                return count;
            }
            // 找到符合要求的了，做标记
            mark[i] = 1;
            mark[index] = 1;
            index++;
            count += 2;
        }
        return count;
    }
}
