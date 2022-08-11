package com.feg.leetcode.question201_300;

import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 */
public class Question283 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 0, 0, 6, 7, 8, 9};
        Question283 question283 = new Question283();
        question283.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0&&j<nums.length-1){
                    if (nums[j+1]==0){
                        int a = j;
                        while (j<nums.length&&nums[j]==0){
                            j++;
                        }
                        if (j==nums.length){
                            continue;
                        }
                        nums[a] = nums[j];
                        nums[j] = 0;
                    }else {
                        nums[j] = nums[j + 1];
                        nums[j + 1] = 0;
                    }
                }
            }
        }
    }
    //方法二，使用快慢双指针
    public void moveZeroes2(int[] nums){
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if (nums[fast] != 0){//移除是0的元素
                if (fast != slow) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        for (int i = slow+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
