package com.feg.leetcode.question1_100;

import com.feg.leetcode.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 前后双指针的方法，遍历一次即可
 */
public class Question19_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode preNode = temp;
        for (int i = 0; i < n; i++) {
            if (preNode.next!=null){
                preNode = preNode.next;
            }
        }
        ListNode backNode = temp;
        while (preNode.next!=null){
            preNode = preNode.next;
            backNode = backNode.next;
        }
        backNode.next = backNode.next.next;
        return temp.next;
    }
}
