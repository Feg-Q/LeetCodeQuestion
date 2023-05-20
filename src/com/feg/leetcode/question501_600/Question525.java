package leetcode.question501_600;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 看了题解，只能说牛啊
 */
public class Question525 {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Question525().findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        int result = 0;
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + (nums[i-1]==0?-1:1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (!map.containsKey(preSum[i])){
                map.put(preSum[i],i);
            }
        }
        for (int i = 1; i < preSum.length; i++) {
            int temp = preSum[i];
            if (map.containsKey(temp)){
                result = Math.max(result,i-map.get(temp));
            }
        }
        return result;
    }
}
