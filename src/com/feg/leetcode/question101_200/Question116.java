package com.feg.leetcode.question101_200;

import com.feg.leetcode.Node;

/**
 * 连接二叉树结点的右侧结点
 * @author Feg
 * @version 1.0
 */
public class Question116 {
    // 遍历的思路，不能用分解问题的思路，因为分解问题是限于一个结点和其左右子节点的范围的
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        getConnect(root.left,root.right);
        return root;
    }
    public void getConnect(Node left,Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        getConnect(left.left,left.right);
        getConnect(left.right,right.left);
        getConnect(right.left,right.right);
    }
}
