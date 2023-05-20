package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // 理论上这里要定义dp数组为前i项中的最大子数组和，但这样递推公式就没办法推导
        //因为无法确定第i项和前面的最大子数组是否紧挨着
        // 要想紧挨着，可以定义为以i为结尾的连续子数组的最大和
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i],nums[i] + dp[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
