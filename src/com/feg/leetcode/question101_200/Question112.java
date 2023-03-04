package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

/**
 * @author Feg
 * @version 1.0
 */
public class Question112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return hasSum(root,0,targetSum);
    }
    public boolean hasSum(TreeNode root,int sum,int targetSum){
        if (root == null){
            return false;
        }
        // 把当前结点的值加上
        sum = sum + root.val;
        // 到达叶子结点
        if (root.left == null && root.right == null){
            if (sum == targetSum){
                return true;
            } else {
                return false;
            }
        }
        // 递归进入左子节点和右子节点，有一个满足条件即可
        return hasSum(root.left,sum,targetSum) || hasSum(root.right,sum,targetSum);
    }
}
