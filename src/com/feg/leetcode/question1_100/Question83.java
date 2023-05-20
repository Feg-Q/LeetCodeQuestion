package leetcode.question1_100;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 */
public class Question83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
//        while (fast.next!=null){
//            if (fast.next.val != fast.val) {
//                if (fast != slow) {
//                    slow.next = fast.next;
//                }
//                slow = slow.next;
//            }
//            fast = fast.next;
//        }
//        if (fast.val == slow.val){
//            slow.next = null;
//        }
        //下面的原理一样
        while (fast!=null){
            if (fast.val!=slow.val){
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
