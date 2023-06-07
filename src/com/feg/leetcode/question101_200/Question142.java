package com.feg.leetcode.question101_200;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/27 9:00
 */
public class Question142 {
    public static ListNode detectCycle(ListNode head) {
        // 边界情况，如果头结点为空，或者头结点的下一个节点为空，则肯定没有环
        if (head == null || head.next == null){
            return null;
        }
        // 快慢指针，初始值直接先往后移一次，防止进不去while循环
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode result = head;
        // 第一次循环，注意快指针的边界，自身和下一个都不能为空
        while (fast != null && fast.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 退出上述循环后，如果是因为快指针后面为空，则肯定没有环
        if (fast == null || fast.next == null){
            return null;
        }
        // 如果是快慢指针相等退出循环的情况，则再次从头结点开始循环等速双指针，遇到的地方就是环的起始点
        while (result != fast){
            result = result.next;
            slow = slow.next;
        }
        return result;
    }
}
