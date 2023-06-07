package com.feg.leetcode.question1_100;

import com.feg.TreeNode;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 * 简简单单的一个中序遍历的递归算法
 * 可以再考虑迭代
 */
public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root!=null) {
            dfs(list, root);
        }
        return list;
    }
    void dfs(List<Integer> list,TreeNode node){
        if (node.left!=null){
            dfs(list,node.left);
        }
        list.add(node.val);
        if (node.right!=null){
            dfs(list,node.right);
        }
    }
    // （2）. 迭代解法
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = new TreeNode();
        temp = root;
        // 下面的代码中循环条件中有一个temp != null ，主要是因为初次进入循环的时候stack还是空，进不去循环，这样可以初次进入循环
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }
}
