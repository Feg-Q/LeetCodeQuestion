package com.feg.leetcode.question201_300;

import com.feg.TreeNode;

/**
 * @author Feg
 * @createDate 2024/12/6 09:37
 * @description 二叉搜索树中第 K 小的元素
 */
public class Question230 {
    
    private int deep = 0;
    private int res = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        deep = k;
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        deep--;
        if (deep <= 0) {
            res = deep == 0 ? root.val : res;
            return;
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
