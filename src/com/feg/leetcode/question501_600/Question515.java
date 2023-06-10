package com.feg.leetcode.question501_600;

import com.feg.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/9 21:18
 * 二叉树的每层的最大值，还是层序遍历，处理每层的时候找出最大值即可，注意临时变量的初始值应该是int类型的最小值
 */
public class Question515 {
    public List<Integer> largestValues(TreeNode root) {
        // 结果集合
        List<Integer> result = new ArrayList<>();
        // 临界判断
        if (root == null) {
            return result;
        }
        // 双端队列，用来存储每一行的结点
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        // 循环直到队列中的最后一个元素被处理
        while (!deque.isEmpty()) {
            // 每次进入while循环都是一个新的一行，因此新建一个变量保存最小值，初始值设置为int类型的最小值
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            // 循环提取size次数据，确保for循环完后处理完了当前行的所有数据
            for (int i = 0; i < size; i++) {
                // 从队列的头部获取并移除一个数据
                TreeNode temp = deque.removeFirst();
                // 将数据添加到结果集中
                max = Math.max(max,temp.val);
                // 把这个结点的左右非空结点加入队列，以便于下一个while循环提取处理
                if (temp.left != null) {
                    deque.addLast(temp.left);
                }
                if (temp.right != null) {
                    deque.addLast(temp.right);
                }
            }
            // 添加到结果集中
            result.add(max);
        }
        return result;
    }
}
