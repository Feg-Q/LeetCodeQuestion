package com.feg.leetcode.question1_100;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/26 22:45
 * 两两交换链表中的节点
 */
public class Question24 {
    public ListNode swapPairs(ListNode head) {
        // 构建两个虚拟头结点，方便前两个节点的交换
        ListNode vHead = new ListNode(-1);
        ListNode preNode = new ListNode(-2);
        // 将虚拟头结点与链表相连
        preNode.next = vHead;
        vHead.next = head;
        // 表示当前节点的指针
        ListNode temp = head;
        // 计数值，偶数时进行节点互换
        int num = 0;
        while (temp != null) {
            num++;
            if (num % 2 == 0) {
                // 先记录好这两个节点的下一个节点
                ListNode tempNode = temp.next;
                // 然后分别记录这两个节点，注意，要用新的节点记录
                ListNode leftNode = preNode.next;
                ListNode rightNode = leftNode.next;
                // 然后交换这两个节点，并连接前一个节点
                preNode.next = rightNode;
                rightNode.next = leftNode;
                leftNode.next = tempNode;
                // 最后将当前节点和前节点这两个指针后移一位
                preNode = preNode.next;
                temp = tempNode;
            } else {
                // 不交换的时候，仅移动指针
                preNode = preNode.next;
                temp = temp.next;
            }
        }
        return vHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        // 构建虚拟头结点
        ListNode dummyList = new ListNode(-1);
        dummyList.next = head;
        ListNode cur = dummyList;
        while(cur.next != null && cur.next.next != null) {
            ListNode left = cur.next;
            ListNode right = cur.next.next;
            cur.next = right;
            left.next = right.next;
            right.next = left;
            cur = left;
        }
        return dummyList.next;
    }
}
