package com.feg.剑指offerll;

import com.feg.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 标准的二叉树的层序遍历，但相比于上一题这里要求按 Z 型输出
 * 解决方法是维护一个int变量记录当前层数，当是偶数层的时候对最后的集合collection反转一下即可
 * @author Feg
 * @version 1.0
 */
public class Question32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        int cell = 1;
        List<List<Integer>> result = new ArrayList<>(); //存储最终结果
        Queue<TreeNode> nodes = new LinkedList<>(); //存储下一行的元素
        nodes.add(root);
        List<Integer> collect = nodes.stream().map(node -> node.val).collect(Collectors.toList());
        result.add(collect);
        while (!nodes.isEmpty()){
            cell++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                // 这里代码提示要加入node的判空操作，但我认为没有必要，循环的条件就是不为空，所以这里不会是null
                if (node.left != null){
                    nodes.add(node.left);
                }
                if (node.right != null){
                    nodes.add(node.right);
                }
            }
            if (nodes.isEmpty()){
                break;
            }
            collect = nodes.stream().map(node -> node.val).collect(Collectors.toList());
            if (cell % 2 == 0){
                Collections.reverse(collect);
            }
            result.add(collect);
        }
        return result;
    }
}
