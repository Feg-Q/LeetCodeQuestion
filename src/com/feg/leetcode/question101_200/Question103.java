package com.feg.leetcode.question101_200;

import com.feg.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/12/3 09:30
 * @description 二叉树的锯齿形层序遍历
 */
public class Question103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return result;
        // 控制存放结果的时候的顺序
        boolean isInvert = false;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayDeque<Integer> res = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode last = deque.pollLast();
                if (isInvert) {
                    res.addFirst(last.val);
                } else {
                    res.addLast(last.val);
                }
                if (last.left != null) deque.addFirst(last.left);
                if (last.right != null) deque.addFirst(last.right);
            }
            isInvert = !isInvert;
            result.add(new ArrayList<>(res));
        }
        return result;
    }
}
