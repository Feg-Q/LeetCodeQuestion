package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * @author Feg
 * @createDate 2024/12/6 09:24
 * @description 把有序数组转换为二叉搜索树
 */
public class Question108 {

    public static void main(String[] args) {
        System.out.println(new Question108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        // 选取数组中间的那个值作为根节点
        int center = (left + right) / 2;
        TreeNode root = new TreeNode(nums[center]);
        root.left = build(nums, left, center - 1);
        root.right = build(nums, center + 1, right);
        return root;
    }
}
