package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/1/9 14:12
 * @description
 */
public class Question80 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new Question80().removeDuplicates(nums));
    }
    
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 1;
        int count = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                count = 1;
            } else {
                count++;
            }
            if (count <= 2 && fast != slow && nums[fast] != nums[slow + 1]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
