package com.feg.leetcode.question1_100;

import com.feg.leetcode.ListNode;

/**
 * 反转链表II
 * @author Feg
 * @version 1.0
 * # 递归实现
 */
public class Question92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left - 1,right - 1);
        return head;
    }
    ListNode most;
    // 递归实现反转链表前n个结点
    public ListNode reverseN(ListNode temp,int n){
        // 当n为1的时候表示到头了，当前只有一个结点了，反转后还是自己，所以直接返回自身
        if (n == 1){
            // 记录好第n+1个结点，便于反转后让末尾的一个指向这第n+1个
            most = temp.next;
            return temp;
        }
        ListNode lastHead = reverseN(temp.next, n - 1);
        temp.next.next = temp;
        temp.next = most;
        return lastHead;
    }
}
