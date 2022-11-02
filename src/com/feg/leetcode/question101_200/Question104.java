package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * 二叉树的最大深度
 * @author Feg
 * @version 1.0
 * 前序遍历，第一种思路
 */
public class Question104 {
    int result = 0; //记录最终结果
    int depth = 0; //记录在遍历的时候的当前结点的深度
    public int maxDepth(TreeNode root) {
        travers(root);
        return result;
    }
    public void travers(TreeNode root){
        if (root == null){
            return;
        }
        depth++; //进入下一层，深度加1
        result = Math.max(result,depth);
        travers(root.left);
        travers(root.right);
        depth--; //离开这一层，深度减1
    }
}
