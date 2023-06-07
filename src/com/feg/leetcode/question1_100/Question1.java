package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/30 12:30
 * 两数之和
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        int[] sum=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    sum[0]=i;
                    sum[1]=j;
                }
            }
        }
        return sum;
    }
}
