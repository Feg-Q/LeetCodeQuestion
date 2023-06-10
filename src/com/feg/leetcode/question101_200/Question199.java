package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/9 20:38
 * 二叉树的右视图，指的是从右侧观察一棵树，所能看到的元素，同样是层序遍历，只不过在每层的最后一个元素的时候保存结果
 */
public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 双端队列，用来存储每一行的结点
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        // 循环直到队列中的最后一个元素被处理
        while (!deque.isEmpty()) {
            // 每次进入while循环都是一个新的一行，因此新建一个当前行的list集合保存结果
            int size = deque.size();
            // 循环提取size次数据，确保for循环完后处理完了当前行的所有数据
            for (int i = 0; i < size; i++) {
                // 从队列的头部获取并移除一个数据
                TreeNode temp = deque.removeFirst();
                // 将数据添加到结果集中
                if (i == size - 1) {
                    result.add(temp.val);
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
        return result;
    }
}
