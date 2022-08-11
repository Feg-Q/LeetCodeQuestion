package com.feg.剑指offerll;

import com.feg.leetcode.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 寻找一个链表中的环的起点
 */
public class Question22 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null && p2.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
            //两个指针相遇，证明有环
            if (p1 == p2){
                break;
            }
        }
        //没有环的情况
        if (p2==null||p2.next==null){
            return null;
        }
        //让慢指针指向头结点，然后相同速度移动，再相遇的地方就是环的起点
        p1 =head;
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
