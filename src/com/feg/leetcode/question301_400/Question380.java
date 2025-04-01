package com.feg.leetcode.question301_400;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Feg
 * @createDate 2025/4/1 11:06
 * @description O(1)时间复杂度实现插入和删除元素
 */
public class Question380 {

    static class RandomizedSet {
        
        private final Random random = new Random();
        private final int[] nums = new int[200000];
        private final Map<Integer, Integer> map;
        private int end = -1;

        public RandomizedSet() {
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            nums[++end] = val;
            map.put(val, end);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            Integer index = map.remove(val);
            if (index != end) map.put(nums[end], index);
            nums[index] = nums[end--];
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(end + 1)];
        }
    }
}
