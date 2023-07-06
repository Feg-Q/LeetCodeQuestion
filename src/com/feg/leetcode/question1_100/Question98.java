package com.feg.leetcode.question1_100;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/6 20:23
 * 验证一个二叉树是否是二叉搜索树
 */
public class Question98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long low, long up) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= up) {
            return false;
        }
        // 对于一个节点的右节点，它的值必须必当前值大，也就是最小值临界是当前值，最大值是整个子树的最大值
        // 而对于左节点，它的最大值是当前值，最小值应该是root结点的值，也就是整个右子树的最小值
        return isValid(root.left, low, root.val) && isValid(root.right, root.val, up);
    }
}
