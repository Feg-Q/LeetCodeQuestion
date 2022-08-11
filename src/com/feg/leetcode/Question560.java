package com.feg.leetcode;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 不看答案还真不好想
 */
public class Question560 {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);//这个是为了补上遍历时当前前缀和就是k的情况，即这时子数组就是从头到这
        preSum[0] = 0;
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            int need = preSum[i] - k;//这是我们所需要的前缀和为这个值，才符合要求
            if (map.containsKey(need)){//找到复合要求的
                result += map.get(need);
            }
            //实在想不到要这样构造map
            if (!map.containsKey(preSum[i])){
                map.put(preSum[i],1);
            }else {
                map.put(preSum[i],map.get(preSum[i])+1);
            }
        }
        return result;
    }
}
