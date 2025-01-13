package com.feg.leetcode.question1_100;

import com.feg.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/12/15 16:45
 * @description
 */
public class Question99 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        // TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node3.right = node2;
        // node4.left = node2;
        new Question99().recoverTree(node1);
        System.out.println(node1.val);
    }
    
    List<TreeNode[]> errorNode = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(errorNode.size());
        System.out.println(errorNode.get(0)[0].val + " " + errorNode.get(0)[1].val);
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode[] treeNode0 = errorNode.get(0);
        if (errorNode.size() == 2) {
            TreeNode[] treeNode1 = errorNode.get(1);
            leftNode = treeNode0[0];
            rightNode = treeNode1[1];
        } else {
            leftNode = treeNode0[0];
            rightNode = treeNode0[1];
        }
        int temp = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = temp;
    }
    
    private void dfs(TreeNode root, int mix, int max) {
        if (root == null) return;
        dfs(root.left, mix, root.val);
        if (root.left != null) {
            int leftVal = root.left.val;
            if (leftVal > root.val || leftVal > max || leftVal < mix) {
                errorNode.add(new TreeNode[]{root.left, root});
            }
        }
        if (root.right != null) {
            int rightVal = root.right.val;
            if (rightVal < root.val || rightVal > max || rightVal < mix) {
                errorNode.add(new TreeNode[]{root, root.right});
            }
        }
        dfs(root.right, root.val, max);
    }
}
