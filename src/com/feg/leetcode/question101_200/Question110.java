package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/10 13:50
 */
public class Question110 {
    // 2. 递归解法，后序遍历（分解子问题的方式）
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return depth(root) != -1;
    }
    // 返回值较为特殊，返回node为根的树的高度，如果不是平衡二叉树，则返回-1
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        // 左右子树的高度差超过1，则返回-1表示已经不是平衡二叉树
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
