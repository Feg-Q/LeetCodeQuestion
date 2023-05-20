package com.feg.leetcode.question1_100;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int count = 0;
        while(true){
            if(l1==null&&l2==null&&count!=0){
                temp.val = 1;
                break;
            }
            if(l1==null&&l2==null){
                break;
            }
            if(l1 !=null && l2 !=null){
                temp.val = l1.val + l2.val+count;
            }
            if(l1 !=null && l2 == null){
                temp.val = l1.val+count;
            }
            if(l1 ==null && l2 != null){
                temp.val = l2.val+count;
            }
            if(temp.val>9){
                count = 1;
                temp.val = temp.val-10;
            }else{
                count = 0;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            if(l1!=null||l2!=null||count!=0){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return result;
    }
}

