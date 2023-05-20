package leetcode.question201_300;

/**
 * 打家劫舍问题，但房屋围成一个环
 * @author Feg
 * @version 1.0
 * 成环的问题就是第一间和最后一间不能同时抢，展开成链就是三种情况，即第一间抢但最后一间不抢，第一间不抢最后一间抢，或者两个都不抢
 * 其中第三种可以不考虑，因为它必然比别的少
 */
public class Question213 {
    public int rob(int[] nums) {
        int length = nums.length;
        // 因为下面有length-2，所以length最小应为2。
        if (length == 1) {
            return nums[0];
        }
        // 比较两种方式的最大者
        return Math.max(commonRob(nums,0,length-2),commonRob(nums,1,length-1));
    }
    // 通用的抢劫计算收益方法，只在start和end之间抢。
    public int commonRob(int[] nums,int start,int end){
        int length = nums.length;
        int[] dpTable = new int[length + 2];
        // 初始化,理论上应该将end往后的都初始化成0，但这里数组默认是0，因此省略初始化
        // 遍历
        for (int i = end; i >= start; i--) {
            dpTable[i] = Math.max(dpTable[i+1], dpTable[i+2] + nums[i]);
        }
        return dpTable[start];
    }
}
