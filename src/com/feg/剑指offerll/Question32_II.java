package com.feg.剑指offerll;

import com.feg.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 标准的二叉树的层序遍历，使用循环来解决
 * @author Feg
 * @version 1.0
 */
public class Question32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>(); //存储最终结果
        Queue<TreeNode> nodes = new LinkedList<>();//存储下一行的元素
        nodes.offer(root);
        List<Integer> collect = nodes.stream().map(node -> node.val).collect(Collectors.toList());
        result.add(collect);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                // 这里代码提示要加入node的判空操作，但我认为没有必要，循环的条件就是不为空，所以这里不会是null
                if (node.left != null){
                    nodes.offer(node.left);
                }
                if (node.right != null){
                    nodes.offer(node.right);
                }
            }
            collect = nodes.stream().map(node -> node.val).collect(Collectors.toList());
            if (collect.isEmpty()){
                continue;
            }
            result.add(collect);
        }
        return result;
    }
}
