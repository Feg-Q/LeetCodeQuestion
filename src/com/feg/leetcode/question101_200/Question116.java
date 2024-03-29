package com.feg.leetcode.question101_200;

import com.feg.leetcode.Node;

import java.util.ArrayDeque;

/**
 * 连接二叉树结点的右侧结点
 * @author Feg
 * @version 1.0
 */
public class Question116 {
    // 1. 遍历的思路，不能用分解问题的思路，因为分解问题是限于一个结点和其左右子节点的范围的
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

    // 2. 使用层序遍历的方法，时间复杂度相比于递归会低一点
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // 双端队列，用来存储每一行的结点
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        // 循环直到队列中的最后一个元素被处理
        while (!deque.isEmpty()) {
            // 每次进入while循环都是一个新的一行
            int size = deque.size();
            // 循环提取size次数据，确保for循环完后处理完了当前行的所有数据
            for (int i = 0; i < size; i++) {
                // 从队列的头部获取并移除一个数据
                Node temp = deque.removeFirst();
                // 将数据添加到结果集中
                if (i < size - 1) {
                    temp.next = deque.peekFirst();
                }
                // 把这个结点的左右非空结点加入队列，以便于下一个while循环提取处理
                if (temp.left != null) {
                    deque.addLast(temp.left);
                }
                if (temp.right != null) {
                    deque.addLast(temp.right);
                }
            }
        }
        return root;
    }
}
