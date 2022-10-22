package com.feg.leetcode;

import java.util.*;

/**
 * 优势洗牌
 * @author Feg
 * @version 1.0
 * #田忌赛马问题，
 * 写题的时候的感悟：最开始自己尝试着写，但忘了优先级队列的排序规则，没办法先写了，之后看结果再改。
 * 然后在对比排序后的两个数组的时候，用了一个map来存储nums2到nums1的映射，
 * 便于之后遍历的时候根据nums2的值get取出想要的nums1的值，但是考虑重复的情况没办法，就先写着。
 * 然后测试了两个没有重复的情况，有一点偏差，因为我判断的等于的情况也算是可以把当前的给到的，不用取最小的，
 * 后来想通了确实应该也取最小的。之后提交就直接败北了，因为nums2元素重复的问题，只能想办法把下标也给保存进去，
 * 但又不知道怎么保存，没有一种结构可以以nums的值为key，下标为value来保存，可重复哈希identityHashMap也不满足要求。
 * 最后还是看算法秘籍的题解才知道可以把下标和值当成一个数组保存到优先级队列中，然后传入自定义的比较器就行了。
 * 优先级队列的poll方法是取得0号元素，所以应该从大到小排序
 *
 * @已解决
 */
public class Question870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.add(new int[]{i,nums2[i]});
        }
        // 给nums1升序排列
        Arrays.sort(nums1);
        // 两个指针，用来方便取出数组1的最大值和最小值
        int right = nums1.length - 1;
        int left = 0;
        // 保存结果信息的数组
        int[] result = new int[nums1.length];
        // 遍历队列，比较大小再决定数组1的顺序
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int j = poll[1];
            if (nums1[right] > j){
                result[poll[0]] = nums1[right--];
            } else {
                result[poll[0]] = nums1[left++];
            }
        }
        return result;
    }
}
