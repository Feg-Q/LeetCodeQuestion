package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

import java.util.ArrayDeque;

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
    //--------------------------------------------------------
    // 2. 迭代解法（层序遍历）
    public int maxDepth2(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        // 双端队列，用来存储每一行的结点
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        // 循环直到队列中的最后一个元素被处理
        while (!deque.isEmpty()) {
            // 每次进入while循环都是一个新的一行
            int size = deque.size();
            // 循环提取size次数据，确保for循环完后处理完了当前行的所有数据
            for (int i = 0; i < size; i++) {
                // 从队列的头部获取并移除一个数据
                TreeNode temp = deque.removeFirst();
                // 执行数据处理
                // 把这个结点的左右非空结点加入队列，以便于下一个while循环提取处理
                if (temp.left != null) {
                    deque.addLast(temp.left);
                }
                if (temp.right != null) {
                    deque.addLast(temp.right);
                }
            }
            // 遍历完一层，深度加一
            depth++;
        }
        return depth;
    }
}
