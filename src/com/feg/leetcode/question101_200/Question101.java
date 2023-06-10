package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/10 9:20
 * 判断一个二叉树是否轴对称，用递归的解法
 */
public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return compare(left.left,right.right) && compare(left.right,right.left);
    }
}
