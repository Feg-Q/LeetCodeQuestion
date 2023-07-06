package com.feg.leetcode.question501_600;

import com.feg.TreeNode;

import java.util.LinkedList;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/14 16:11
 * 找出二叉树最底层的最左侧的结点的值，用层序遍历
 */
public class Question513 {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode result = root;
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            result = list.peekFirst();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return result.val;
    }
}
