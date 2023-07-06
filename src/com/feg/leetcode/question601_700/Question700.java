package com.feg.leetcode.question601_700;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/1 15:43
 * 二叉搜索树
 */
public class Question700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftResult = searchBST(root.left, val);
        TreeNode rightResult = searchBST(root.right, val);
        return leftResult == null ? rightResult : leftResult;
    }
}
