package com.feg.other;

import java.util.*;
// 主类和主方法（程序入口）
public class PlankMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取木板数n和木料长度m
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 创建一个整数数组，存储木板长度
        int[] a = new int[n];
        // 读取每块木板的长度，并记录最大值和最小值
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        // 定义二分查找的左右边界，初始为最小值和最大值
        int left = min;
        int right = max;
        // 定义答案变量，初始为最小值
        int ans = min;
        // 当左边界小于等于右边界时，继续二分查找
        while (left <= right) {
            // 计算中间值（目标长度）
            int mid = (left + right) / 2;
            // 计算需要切割的木料总长度
            int cut = 0;
            for (int x : a) {
                if (x < mid) {
                    cut += mid - x;
                }
            }
            // 如果切割的木料总长度小于等于m，说明目标长度可行，更新答案并将左边界右移
            if (cut <= m) {
                ans = mid;
                left = mid + 1;
            } else { // 否则，说明目标长度过大，将右边界左移
                right = mid - 1;
            }
        }
       System.out.println(ans); 
   } 
}