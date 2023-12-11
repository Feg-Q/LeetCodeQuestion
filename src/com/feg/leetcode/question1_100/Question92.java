package com.feg.leetcode.question1_100;

import com.feg.ListNode;

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

    /**
     * 头插法实现
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 先找到下一个节点是left的节点
        ListNode cur = head;
        int dur = right - left;
        while (cur != null && left > 1) {
            cur = cur.next;
            left--;
        }
        // 记录要遍历的指针，以及记录好区间的第一个节点
        ListNode vList = new ListNode(-1);
        while (cur != null && dur >= 0) {
            ListNode next = cur.next;
            cur.next = vList.next;
            vList.next = cur;
            cur = next;
            dur--;
        }
        return head;
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode dummyList = new ListNode(-1);
        dummyList.next = head;
        // 先找到left左边的那一个
        ListNode pre = dummyList;
        for(int i = 0;i < left - 1;i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for(int i = 0;i < right - left + 1;i++) {
            rightNode = rightNode.next;
        }
        ListNode next = rightNode.next;
        rightNode.next = null;
        // pre.next = null;
        ListNode res = reverseList(pre.next);
        pre.next = res;
        leftNode.next = next;
        return dummyList.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
