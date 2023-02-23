package com.feg.other;

import java.util.*;

public class Solution {
    // 定义一个颜色数组，存储每个节点的颜色，0表示未染色，1表示红色，2表示黑色
    static int[] color;
    // 定义一个邻接表，存储图的结构
    static List<List<Integer>> adj;
    // 定义一个答案变量，初始为0
    static int ans = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取节点数n和边数m
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 初始化颜色数组和邻接表
        color = new int[n];
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // 读取每条边的两个端点，并添加到邻接表中
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            adj.get(s).add(t);
            adj.get(t).add(s);
        }
        
        // 遍历所有未染色的节点，并对其进行深度优先搜索（从红色开始）
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                // 如果深度优先搜索成功，则答案乘以2（因为可以反转整个连通分量的颜色）
                if (dfs(i, 1)) {
                    ans *= 2;
                } else { // 否则说明无法满足条件，直接输出0并退出程序 
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(ans);
    }

    // 定义一个深度优先搜索函数，参数为当前节点和当前颜色
    public static boolean dfs(int u, int c) {
         // 将当前节点染成当前颜色
         color[u] = c;
         // 遍历当前节点的所有邻居节点
         for (int v : adj.get(u)) {
             // 如果邻居节点已经染成了相同颜色，说明不符合条件，直接返回False
             if (color[v] == c) return false;
             // 如果邻居节点还未染色，递归地对其进行深度优先搜索，并将颜色反转（1->2或2->1）
             if (color[v] == 0 && !dfs(v, 3 - c)) return false;
         }
         // 如果所有邻居节点都满足条件，返回True    
         return true;
     }
}