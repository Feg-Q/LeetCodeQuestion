package com.feg.huaweiod;

import java.util.Scanner;
import java.util.*;

class WaterContainer {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 转为数组
        Integer[] height = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int left = 0;
        int right = height.length - 1;
        int[] result = new int[3];
        int capacity = 0;
        while (left < right) {
            int sum = 0;
            int lower = Math.min(height[left], height[right]);
            for (int i = left; i <= right; i++) {
                sum += Math.max(0, lower - height[i]);
            }
            if (sum >= capacity) {
                result = new int[]{left, right, sum};
                capacity = sum;
            }
            if (height[right - 1] >= height[left] && height[right - 1] >= height[right]) right--;
            else if (height[left] < height[right]) left++;
            else if (height[left + 1] >= height[right] && height[left + 1] >= height[left]) left++;
            else if (height[left] > height[right]) right--;
            else right--;
        }
        if (result[2] == 0) {
            System.out.println(0);
        } else {
            System.out.print(result[0]);
            System.out.print(" ");
            System.out.print(result[1]);
            System.out.print(":");
            System.out.print(result[2]);
        }
    }
}