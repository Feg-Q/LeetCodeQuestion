package leetcode.question201_300;

import com.feg.ListNode;

/**
 * @author Feg
 * @version 1.0
 */
public class Question203 {
    public ListNode removeElements(ListNode head, int val) {
        // 创建一个虚拟头结点
        ListNode temp = new ListNode();
        // 创建一个新链表的指针
        ListNode res = temp;
        while (true){
            // 如果旧链表的指针到了末尾了
            if (head == null){
                break;
            }
            // 如果值不相等，那就把当前旧指针挂到新指针后面，并两个指着都往后移动一位
            if (head.val != val){
                temp.next = head;
                head = head.next;
                temp = temp.next;
            } else { // 如果不相等，把旧指针往后移，然后断开新指针后面的
                head = head.next;
                temp.next = null;
            }
        }
        // 防止空链表的情况
        return res.next == null ? null : res.next;
    }
}
