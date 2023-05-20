package leetcode.question501_600;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 用前缀和技巧来解决连续子数组问题
 */
public class Question523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //构造前缀和数组
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        //创建map来保存每一个不重复的前缀和
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //将等号右边的所需的值保存在map中
        for (int i = 0; i < preSum.length; i++) {
            int value = preSum[i] % k;
            if (!hashMap.containsKey(value)){
                hashMap.put(value,i);
            }
        }
        //遍历，然后与等号右边的值比较
        for (int i = 1; i < preSum.length; i++) {
            int need = preSum[i] % k;
            if (hashMap.containsKey(need)){
                if ((i-hashMap.get(need))>=2){
                    return true;
                }
            }
        }
        return false;
    }
}
