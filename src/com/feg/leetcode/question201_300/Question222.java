package com.feg.leetcode.question201_300;

import com.feg.TreeNode;

import java.util.LinkedList;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/10 11:23
 * 完美二叉树的结点个数
 */
public class Question222 {
    // 1. 根据完全二叉树的性质
    public int countNodes(TreeNode root) {
        return dp(root);
    }
    // 定义dp函数，返回值是root为根节点的满二叉树的结点个数（2*depth-1）
    public int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 下面的操作是判断一棵树是不是满二叉树，即每层都占满的二叉树
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        // 判断这颗树是否是满二叉树
        if (leftDepth == rightDepth) {
            // 注意要先位运算再减一，及先指数
            return (2 << leftDepth) - 1;
        }
        // 返回左右子树的个数加上自身的个数
        return dp(root.left) + dp(root.right) + 1;
    }

    // 2. 层序遍历解法,但这样就和普通的二叉树没有区别了
    public int countNodes2(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int num = 0;
        if (root == null) {
            return num;
        }
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            num++;
            if (poll.left != null) {
                list.add(poll.left);
            }
            if (poll.right != null) {
                list.add(poll.right);
            }
        }
        return num;
    }
}
