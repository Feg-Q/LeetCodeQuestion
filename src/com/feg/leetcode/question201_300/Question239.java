package com.feg.leetcode.question201_300;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 有一个整数数组，一个滑动窗口，滑动窗口一次移动一个值，返回窗口的最大值。
 * @author Feg
 * @version 1.0
 */
public class Question239 {
    class MonotonicQueue {
        // 使用双向链表实现单调队列
        LinkedList<Integer> que = new LinkedList<>();
        public void push(int val) {
            // 把小于val的值都删除,注意这里是小于
            while (!que.isEmpty() && que.getLast() < val){
                que.removeLast();
            }
            que.addLast(val);
        }
        public void pop(int val) {
            // 单调队列中最左边的一定是最大值，即如果要移除的值在这个窗口中不是最大值，那么这个值就不在队列中，不需要移除
            // 而如果要移除的就是最大值，那么就移除最左边的即可；
            // 这里不可能移除到队列中最大值右边的值，因为最大值右边的值必定在原数组中是位于这个最大值之后的。
            if (val == que.getFirst()){
                que.pollFirst();
            }
        }
        public int max() {
            // 单调队列最左边的就是最大值。
            return que.getFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        MonotonicQueue queue = new MonotonicQueue();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                list.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
