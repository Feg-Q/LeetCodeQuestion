package com.feg.leetcode.question801_900;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 快慢指针的方法,快多了
 */
public class Question876_2 {
    public ListNode middleNode(ListNode head) {
        ListNode preNode = head;
        ListNode backNode = head;
        while (preNode!=null && preNode.next!=null){
            preNode = preNode.next.next;
            backNode = backNode.next;
        }
        return backNode;
    }
}
