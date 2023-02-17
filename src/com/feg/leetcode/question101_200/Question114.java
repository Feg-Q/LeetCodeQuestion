package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * 将一个二叉树转换成右链表，在原来的二叉树上操作，即全部挂载到右节点。
 * @author Feg
 * @version 1.0
 */
public class Question114 {
    // 用分解问题的思路，不能用递归的思路，因为flatten方法返回值为空
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先将左右子树转换完成。
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
