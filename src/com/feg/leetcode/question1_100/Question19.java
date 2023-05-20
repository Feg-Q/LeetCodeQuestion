package com.feg.leetcode.question1_100;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 链表的双指针，通用链表结点类在Question2
 */
public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;//head表示待删除结点
        //遍历确定长度
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode left = head;//left表示待删除结点左边的那一个
        temp = head.next;
        for (int i = 0; i < length - n - 1; i++) {
            left = left.next;
            temp = temp.next;
        }
        //System.out.println(temp.val);
        if (length == 1 || length - n <= 0) {//要删除的结点是头结点的情况
            head = head.next;
        } else {
            left.next = temp.next;
        }
        return head;
    }
}
