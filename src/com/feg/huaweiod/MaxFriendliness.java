package com.feg.huaweiod;

import java.util.Scanner;
import java.util.*;

class MaxFriendliness {
	public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 获取到输入的每个座位的情况（0,1,2）
        Integer[] seats = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
 
        ArrayList<Integer> left_result_arr = new ArrayList<Integer>();
        // 用来统计左边友好度的变量
        Integer left_result = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                left_result_arr.add(left_result);
                left_result = 0;
            } else if (seats[i] == 1) {
                left_result +=1;
            } else {
                left_result =0;
            }
        }
 
        ArrayList<Integer> right_result_arr = new ArrayList<Integer>();
        Integer right_result = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                right_result_arr.add(right_result);
                right_result = 0;
            } else if (seats[i] == 1) {
                right_result +=1;
            } else {
                right_result =0;
            }
        }
        
        int result = 0;
        for (int i = 0; i < left_result_arr.size(); i++) {
            result = Math.max(result, left_result_arr.get(i) + right_result_arr.get(left_result_arr.size()-i-1));
        }
        System.out.println(result);
    }
 
}