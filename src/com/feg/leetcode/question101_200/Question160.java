package com.feg.leetcode.question101_200;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 判断两条链表是否相交
 */
public class Question160 {
    //方法一
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = 0;
        int lengthB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=null){
            p1 = p1.next;
            lengthA++;
        }
        while (p2!=null){
            p2 = p2.next;
            lengthB++;
        }
        p1 = headA;
        p2 = headB;
        if (lengthA>lengthB){
            for (int i = 0; i < lengthA - lengthB; i++) {
                p1 = p1.next;
            }
        }else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                p2 = p2.next;
            }
        }
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    //方法二
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=p2){
            if (p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            if (p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
