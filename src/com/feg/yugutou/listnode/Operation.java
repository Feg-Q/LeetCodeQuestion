package com.feg.yugutou.listnode;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/11/30 19:42
 */
public class Operation {

    /**
     * 使用栈查找两个链表的公共节点
     */
    public ListNode findFirstCommonNodeStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            stackB.add(headB);
            headB = headB.next;
        }

        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode popA = stackA.pop();
            ListNode popB = stackB.pop();
            if (popA.val == popB.val) {
                result = popA;
            }
        }
        return result;
    }

    /**
     * 使用双指针合并两个有序链表成一个有序链表
     */
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode headResult = new ListNode(-1);
        ListNode temp = headResult;
        while (headA != null && headB != null) {
            if (headA.val > headB.val) {
                temp.next = headB;
                headB = headB.next;
            } else {
                temp.next = headA;
                headA = headA.next;
            }
            temp = temp.next;
        }
        if (headA != null) {
            temp.next = headA;
        }
        if (headB != null) {
            temp.next = headB;
        }
        return headResult.next;
    }

    /**
     * 合并K歌链表（两两合并）
     */
    public ListNode mergeKLists(ListNode[] listNodes) {
        ListNode temp = null;
        for (ListNode listNode : listNodes) {
            temp = mergeTwoLists(temp,listNode);
        }
        return temp;
    }

    /**
     * 将链表A的a-b区间删除，把链表B接上
     */
    public ListNode mergeInBetween(ListNode headA, int a, int b, ListNode headB) {
        ListNode result = headA;
        ListNode tempA = headA;
        ListNode tempB = null;
        while (headA.next != null) {
            if (a == 0) {
                tempA = headA;
            }
            if (b == 0) {
                tempB = headA;
            }
            a--;
            headA = headA.next;
        }
        tempA.next = headB;
        while (headB.next != null) {
            headB= headB.next;
        }
        headB.next = tempB;
        return result;
    }

    /**
     * 链表的中间结点
     */
    public ListNode middleNode(ListNode head) {
        ListNode tempA = head;
        ListNode tempB = head;
        while (tempB != null && tempB.next != null) {
            tempA = tempA.next;
            tempB = tempB.next.next;
        }
        return tempA;
    }

    /**
     * 获取链表的倒数第K个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 将链表右移K位
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 理论上k经过处理后，fast一定不会为null
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }

    /**
     * 删除链表中值等于val的结点
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 删除链表的倒数第N个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempA = head;
        ListNode tempB = head;
        int k = n;
        while (tempB != null && k > 0) {
            tempB = tempB.next;
            k--;
        }
        while (tempB != null && n > 1) {
            tempA = tempA.next;
            tempB = tempB.next;
            n--;
        }
        tempA.next = tempA.next.next;
        return head;
    }

    /**
     * 删除链表中的重复元素，只保留一个
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 删除链表中的重复元素，一个都不留
     */
    public ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                int value = temp.next.val;
                while (temp.next != null && temp.next.val == value) {
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    /**
     * 翻转链表-虚拟头结点
     */
    public ListNode reverseList(ListNode head) {
        ListNode vList = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = vList.next;
            vList.next = cur;
            cur = temp;
        }
        return vList.next;
    }

    /**
     * 反转链表-直接操作链表
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            next = next.next;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
