package com.feg.leetcode.question601_700;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/1 15:20
 * 合并二叉树
 */
public class Question617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 两个节点都是空的情况
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode temp = new TreeNode();
        // 两个节点都不是空的情况
        if (root1 != null && root2 != null) {
            temp.val = root1.val + root2.val;
            temp.left = mergeTrees(root1.left, root2.left);
            temp.right = mergeTrees(root1.right,root2.right);
        } else {
            // 有一个节点是空的情况
            return root1 == null ? root2 : root1;
        }
        return temp;
    }
}
