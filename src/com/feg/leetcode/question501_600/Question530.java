package com.feg.leetcode.question501_600;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/8 19:22
 * 找出一个二叉搜索树的任意两个结点的最小差值（正数）
 */
public class Question530 {

    TreeNode pre;
    public int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (pre != null) {
            result = Math.min(root.val -pre.val,result);
        }
        pre = root;
        dfs(root.right);
    }
}
