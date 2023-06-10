package com.feg.leetcode.question401_500;

import com.feg.NNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/9 21:09
 * N叉树的层序遍历，只需要将二叉树的层序遍历的添加左右非空子节点的操作换成添加子节点集合中的结点即可，不过这样好像时间复杂度很高
 */
public class Question429 {
    public List<List<Integer>> levelOrder(NNode root) {
        // 结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 临界判断
        if (root == null) {
            return result;
        }
        // 双端队列，用来存储每一行的结点
        ArrayDeque<NNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        // 循环直到队列中的最后一个元素被处理
        while (!deque.isEmpty()) {
            // 每次进入while循环都是一个新的一行，因此新建一个当前行的list集合保存结果
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();
            // 循环提取size次数据，确保for循环完后处理完了当前行的所有数据
            for (int i = 0; i < size; i++) {
                // 从队列的头部获取并移除一个数据
                NNode temp = deque.removeFirst();
                // 将数据添加到结果集中
                list.add(temp.val);
                // 把这个结点的子非空结点加入队列，以便于下一个while循环提取处理
                for (NNode child : temp.children) {
                    deque.addLast(child);
                }
            }
            result.add(list);
        }
        return result;
    }
}
