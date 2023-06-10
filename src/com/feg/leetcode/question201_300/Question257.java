package com.feg.leetcode.question201_300;

import com.feg.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/10 14:34
 */
public class Question257 {

    // 用来在递归过程中保存临时变量
    List<List<Integer>> resultTemp = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root);
        // 处理每一个内部集合，转换成字符串添加到结果集中
        for (List<Integer> integerList : resultTemp) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int integer : integerList) {
                stringBuilder.append(integer).append("->");
            }
            result.add(stringBuilder.substring(0,stringBuilder.length() - 2));
        }
        return result;
    }
    public void dfs(TreeNode node) {
        // 先把当前节点添加到集合中
        temp.addLast(node.val);
        // 如果到达叶子结点（左右子节点均为null）
        if (node.left == null && node.right == null) {
            // 先保存在临时结果集中
            resultTemp.add(new ArrayList<>(temp));
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        // 遍历完当前节点，移除当前节点
        temp.removeLast();
    }
}
