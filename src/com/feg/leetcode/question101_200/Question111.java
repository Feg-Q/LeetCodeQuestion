package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数的最小深度问题，标准的广度优先搜索算法
 * @author Feg
 * @version 1.0
 */
public class Question111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // for循环用来控制当前层的节点数量，循环结束即要转向下一层。
            for (int i = 0; i < size; i++) {
                // 取出本层的下一个节点
                TreeNode node = queue.poll();
                // 如果这个节点没有左右子节点，则到达叶子位置
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left!= null) {
                    queue.offer(node.left);
                }
                if (node.right!= null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
