package com.feg.leetcode.question101_200;

import com.feg.leetcode.Node;

import java.util.ArrayDeque;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/9 21:34
 *  * 连接二叉树结点的右侧结点，不限制二叉树是完美二叉树
 *  代码上和116题一模一样，一点都没有改变
 */
public class Question117 {
    // 使用层序遍历的方法，时间复杂度相比于递归会低一点
    public Node connect(Node root) {
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
