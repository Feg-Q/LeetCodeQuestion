package com.feg.leetcode.question201_300;

import com.feg.TreeNode;
/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/16 14:37
 * 寻找一颗二叉树中两个节点的最近的公共祖先
 * 想法，从底往上遍历，用到后序遍历（从底往上）
 */
public class Question236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.left, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null){
            return leftNode;
        } else {
            return rightNode;
        }
    }
}
