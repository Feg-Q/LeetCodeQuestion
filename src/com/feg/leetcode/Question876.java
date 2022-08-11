package com.feg.leetcode;

/**
 * @author Feg
 * @version 1.0
 * 常规解法，遍历一次确定长度，再遍历一半找中间结点
 */
public class Question876 {
    public ListNode middleNode(ListNode head) {
        System.out.println(head.val);
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        System.out.println(length);
        int mid = (int)length/2+1;
        System.out.println(mid);
        if(mid==1){
            return head;
        }else{
            temp = head;
            while(--mid>0){
                temp = temp.next;
            }
            return temp;
        }
    }
}
