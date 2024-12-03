package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/12/3 09:29
 * @description 二叉树的后序遍历
 */
public class Question145 {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        res.add(root.val);
    }
}
