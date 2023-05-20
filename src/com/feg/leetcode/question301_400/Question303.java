package com.feg.leetcode.question301_400;

/**
 * @author Feg
 * @version 1.0
 */
public class Question303 {

}
//前缀和的方法
class NumArray{
    private int[] nums;
    int[] preSum;
    public NumArray(int[] nums){
        this.nums = nums;
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

    }
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left+1];
    }
}
//常规解法，复杂度较高
//class NumArray {
//    private int[] nums;
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//    public int sumRange(int left, int right) {
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            res = res + nums[i];
//        }
//        return res;
//    }
//}
