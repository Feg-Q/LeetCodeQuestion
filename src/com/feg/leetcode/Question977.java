package com.feg.leetcode;

/**
 * @author Feg
 * @version 1.0
 * 考虑四种情况，还算简单，就是代码比较多
 * 卧槽，还有这么简单的算法
 */
public class Question977 {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left;
        int right;
        int[] result = new int[length];
        if(nums[0]>=0){
            right=0;
            left=-1;
        }else{
            left = 0;
            right = 1;
        }
        while(right<length && nums[right]<=0){
            right++;
            left++;
        }
        if(left==-1){//全正数的情况
            for(int i=0;i<length;i++){
                result[i] = nums[i]*nums[i];
            }
        }else if(right==length){//全负数的情况
            for(int i=0,j=length-1;i<length;i++,j--){
                result[i] = nums[j]*nums[j];
            }
        }else{
            int i = 0;
            while(left>=0&&right<length){
                int leftValue = nums[left]*nums[left];
                int rightValue = nums[right]*nums[right];
                if(leftValue>rightValue){
                    result[i] = rightValue;
                    right++;
                }else{
                    result[i] = leftValue;
                    left--;
                }
                i++;
            }
            if(left<0&&right<length){
                while(right<length){
                    result[i] = nums[right]*nums[right];
                    i++;
                    right++;
                }
            }else if(right>=length&&left>=0){
                while(left>=0){
                    result[i] = nums[left]*nums[left];
                    i++;
                    left--;
                }
            }
        }
        return result;
    }
}
