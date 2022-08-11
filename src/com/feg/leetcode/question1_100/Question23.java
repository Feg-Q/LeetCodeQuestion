package com.feg.leetcode.question1_100;

import com.feg.leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * @author Feg
 * @version 1.0
 * k个有序链表的合并，用到排序队列
 */
public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        ListNode listNode = new ListNode();
        ListNode tempNode = listNode;
        //用优先级队列来查找k个结点的值最小的结点
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a, b)->(a.val - b.val));
        //初始化把k个链表的头结点放入队列
        for (ListNode list : lists) {
            if (list!=null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()){
            ListNode poll = queue.poll();//取出队列中的最小的一个
            tempNode.next = poll;
            //把取出的结点的后一个再加入到队列
            if (poll.next!=null){
                queue.add(poll.next);
            }
            //移动结果队列的指针
            tempNode = tempNode.next;
        }
        return listNode.next;
    }
}
