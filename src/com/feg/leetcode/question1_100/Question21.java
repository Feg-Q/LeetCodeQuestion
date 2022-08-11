package com.feg.leetcode.question1_100;

import com.feg.leetcode.ListNode;

/**
 * @author Feg
 * @version 1.0
 */
public class Question21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null&&temp2==null){
            while(temp1!=null){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }
        }
        if(temp2!=null&&temp1==null){
            while(temp2!=null){
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        return head.next;
    }
}
