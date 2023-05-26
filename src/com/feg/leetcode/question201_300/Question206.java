package com.feg.leetcode.question201_300;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/26 22:36
 * 反转链表/头插法
 */
public class Question206 {
    public ListNode reverseList(ListNode head) {
        // 构建虚拟头结点
        ListNode headNode = new ListNode();
        // 指针，在链表上游走
        ListNode temp = head;
        while (temp != null){
            // 先记录好下一个节点
            ListNode tempNode = temp.next;
            // 把当前节点的next指向真正的头结点
            temp.next = headNode.next;
            // 然后把当前节点挂到虚拟头结点上
            headNode.next = temp;
            // 最后将指针指向下一个节点
            temp = tempNode;
        }
        return headNode.next;
    }
}
