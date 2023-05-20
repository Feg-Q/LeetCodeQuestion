package com.feg.huaweiod;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.stream.Stream;
 
class Main {
	public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        List<Integer> file_ids =Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> sizes =Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
 
        // key为文件标识 value为文件出现的次数
        HashMap<Integer, Integer> file_map = new HashMap<>();
        // key为文件标识 value为扫描成本
        HashMap<Integer, Integer> file_cost = new HashMap<>();
    
        for (int i = 0; i < file_ids.size(); i++) {
            file_map.put(file_ids.get(i), file_map.getOrDefault(file_ids.get(i), 0) + 1);
            file_cost.putIfAbsent(file_ids.get(i), sizes.get(i));
        }
    
        int result = 0;
        for (int k : file_map.keySet()) {
            result += Math.min(file_map.get(k) * file_cost.get(k), file_cost.get(k) + m);
        }
    
        System.out.println(result);
 
        
  }
 
    
}