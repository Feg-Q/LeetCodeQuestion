package com.feg.leetcode.question501_600;

import com.feg.TreeNode;

/**
 * @author Feg
 * @createDate 2024/11/30 22:02
 * @description
 */
public class Question543 {
    
    private int maxInt = 0; 
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxInt;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDeep = dfs(root.left);
        int rightDeep = dfs(root.right);
        maxInt = Math.max(leftDeep + rightDeep, maxInt);
        // 返回以这个节点作为根节点的左子树或右子树的最大深度
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }
}
