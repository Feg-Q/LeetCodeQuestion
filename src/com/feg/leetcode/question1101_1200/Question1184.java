package com.feg.leetcode.question1101_1200;

/**
 * @author Feg
 * @createDate 2024/9/16 17:42
 * @description 给出一个数组可以构成一个环形的线路，再给出出发点和终点，可以往前也可以往后走，计算从出发点到终点的最近距离
 * 这道题目其实很简单，因为从出发点到终点只有两条路走，要么一直往前，要么一直往后，
 * 因此以出发点和终点来将数组分割成三部分，中间部分既是方案一，其它两部分加和就是方案二，一次遍历即可计算两种方案的总和
 * 特殊处理，起点大于终点的情况只需要交换起点和终点即可
 */
public class Question1184 {

    public static void main(String[] args) {
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination = 1;
        System.out.println(new Question1184().distanceBetweenBusStops(distance, start, destination));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 先调整下方向，比如从7到2的位置其实和从2到7是一样的
        if(start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i < start || i >= destination) {
                rightCount += distance[i];
            } else {
                leftCount += distance[i];
            }
        }
        return Math.min(leftCount, rightCount);
    }
}
