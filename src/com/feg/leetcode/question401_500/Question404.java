package com.feg.leetcode.question401_500;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/14 11:51
 * 二叉树的所有左叶子结点之和
 */
public class Question404 {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return sum;
    }
    public void dfs(TreeNode root,boolean isLeft) {
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        } else {
            if (root.left != null) {
                dfs(root.left,true);
            }
            if (root.right != null) {
                dfs(root.right,false);
            }
        }
    }
}
