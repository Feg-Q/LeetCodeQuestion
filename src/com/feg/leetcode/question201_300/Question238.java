package com.feg.leetcode.question201_300;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2025/4/3 15:03
 * @description 数组中除自身以外的数字的乘积
 */
public class Question238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Question238().productExceptSelf(nums)));
    }
    
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftNums = new int[length];
        int[] rightNums = new int[length];
        for (int i = 0; i < length; i++) {
            int leftNum = nums[i];
            int rightNum = nums[length - 1 - i];
            if (i == 0) {
                leftNums[i] = leftNum;
                rightNums[length - 1 - i] = rightNum;
            } else {
                leftNums[i] = leftNums[i -1] * leftNum;
                rightNums[length - 1 - i] = rightNums[length - i] * rightNum;
            }
        }
        int[] answer = new int[length];
        answer[0] = rightNums[1];
        answer[length - 1] = leftNums[length - 2];
        for (int i = 1; i < length - 1; i++) {
            answer[i] = leftNums[i - 1] * rightNums[i + 1];
        }
        return answer;
    }
}
