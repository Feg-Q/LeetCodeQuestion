package com.feg;

/**
 * @author Feg
 * @version 1.0
 */
//共用的链表结点
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
