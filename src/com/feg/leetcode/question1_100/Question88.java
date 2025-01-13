package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2025/1/8 10:09
 * @description 合并两个有序数组，要求空间复杂度O(1)
 */
public class Question88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Question88().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.printf(i + " ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[right] = nums1[m];
                m--;
            } else {
                nums1[right] = nums2[n];
                n--;
            }
            right--;
        }
        if (m < 0) {
            while (right >= 0) {
                nums1[right--] = nums2[n--];
            }
        }
    }
}
