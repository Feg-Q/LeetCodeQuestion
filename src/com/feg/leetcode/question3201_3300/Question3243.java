package com.feg.leetcode.question3201_3300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/11/19 08:39
 * @description
 */
public class Question3243 {

    public static void main(String[] args) {
        int[][] queries = new int[][]{{0,4},{0,2},{1,8},{6,8}};
        System.out.println(Arrays.toString(new Question3243().shortestDistanceAfterQueries(9, queries)));
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length]; // 先定义结果集
        
        // 定义一个有向图，temp[i]的位置保存的事i可以指向哪些位置
        List<Integer>[] temp = new ArrayList[n -1];
        Arrays.setAll(temp, i -> new ArrayList<>());
        // 初始化每个i位置都有指向i + 1的箭头
        for (int i = 0; i < n - 1; i++) {
            temp[i].add(i + 1);
        }

        // 用来判断i的位置之前是否有用来当过起点
        int[] isUsed = new int[n - 1];
        // 逐次遍历条件，添加一个方向箭头，然后bfs求结果
        for (int i = 0; i < queries.length; i++) {
            temp[queries[i][0]].add(queries[i][1]);
            isUsed = new int[n - 1]; // 每循环一次重置一次标记数组
            res[i] = bfs(temp, i + 1, n, isUsed);
        }
        return res;
    }
    
    public int bfs(List<Integer>[] temp, int index, int n, int[] isUsed) {
        // 用来表明还有哪些位置可以用来当做起点
        List<Integer> q = new ArrayList<>();
        // 最开始的起点就是0的位置
        q.add(0);
        // 一次走一步
        for (int step = 1; ; step++) {
            // 这里其实是仿照多叉树的层序遍历的方式，每走一层，下面一层就是一个新的起点集合，然后只遍历当前层的起点集合
            List<Integer> t = q;
            q = new ArrayList<>();
            // start是起点，end是终点，一个起点有多个终点，把每一个终点当做下一个的起点，然后重新添加到起点集合中
            for (int start : t) {
                for (int end : temp[start]) {
                    if (end == n - 1) {
                        return step;
                    }
                    // 这里其实就是来表示当前位置是否已经被当做起点过，如果当做过，那前面的那次的路线一定更少，所以这一次直接忽略
                    if (isUsed[end] != end) {
                        isUsed[end] = end;
                        q.add(end);
                    }
                }
            }
        }
    }
}
