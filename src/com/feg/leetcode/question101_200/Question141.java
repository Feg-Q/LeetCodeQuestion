package com.feg.leetcode.question101_200;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 链表中的环
 */
public class Question141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null&&p2.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
            if (p2 == p1){
                return true;
            }
        }
        return false;
    }
}
