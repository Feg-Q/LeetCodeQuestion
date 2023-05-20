package leetcode.question1_100;


import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 * 把一个链表中小于x的结点排到大于等于x的结点前面
 */
public class Question87 {
    public ListNode partition(ListNode head, int x) {
        //创建两个虚拟头结点
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        //创建两个指针指向两个头结点
        ListNode point1 = dummy1;
        ListNode point2 = dummy2;
        //创建一个遍历原链表的指针
        ListNode p = head;

        ListNode temp = null;
        while (p!=null){
            if (p.val<x){
                point1.next = p;
                point1 = point1.next;
            }else {
                point2.next = p;
                point2 = point2.next;
            }
            temp = p.next;
            p.next = null;
            p = temp;
        }
        point1.next = dummy2.next;
        return dummy1.next;
    }
}
