package com.feg.leetcode.question501_600;

import com.feg.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/7/10 21:23
 * 二叉搜索树中的众数
 */
public class Question501 {

    TreeNode pre;
    int resultInt = 1;
    int tempInt = 1;

    ArrayList<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        AtomicInteger i = new AtomicInteger();
        int[] reInt = new int[result.size()];
        result.forEach((value) -> reInt[i.getAndIncrement()] = value);
        return reInt;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 这时候有三种情况，1.前一个节点是null
        if (pre != null) {
            // 当前节点值和上一个节点相等,那就把临时计数器加一
            if (pre.val == root.val) {
                tempInt++;
            } else { // 不相等就要把临时计数器重置为1
                tempInt = 1;
            }
            // 判断连续长度是否和已经记录的最大长度相等，如果相等（包括都为1的情况），就把当前值添加到结果集
            if (tempInt == resultInt) {
                result.add(root.val);
            } else if (tempInt > resultInt) { // 如果比记录的大，那就更新结果集和结果最大值
                result = new ArrayList<>();
                result.add(root.val);
                resultInt = tempInt;
            }
        } else { // 此时只有一种情况，那就是当前在遍历到的第一个节点，此时应该把第一个节点的值放到结果集中
            // 防止一种情况：即没有一个重复的值
            result.add(root.val);
        }
        // 更新前指针
        pre = root;
        dfs(root.right);
    }
}
