package com.feg.剑指offerll;

import com.feg.leetcode.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 逆序输出一个链表的各节点的值
 * 刚开始思路是遍历链表，把每个值保存在一个集合中（可变数组），
 * 然后再翻转这个集合，然而找不到集合转换成数组的方式（再遍历浪费了），
 * 看了题解这种递归的思路很不错，尤其是初始化结果数组的地方，
 * 以及两个变量控制索引。
 */
public class Question06 {
    // 全局变量，便于递归时调用
    int[] results;
    int i = 0;
    int j = 0;
    public int[] reversePrint(ListNode head) {
        dfs(head);
        return results;
    }
    public void dfs(ListNode temp){
        if (temp == null){
            results = new int[i];
            return;
        }
        i++;
        dfs(temp.next);
        results[j] = temp.val;
        j++;
    }
}
