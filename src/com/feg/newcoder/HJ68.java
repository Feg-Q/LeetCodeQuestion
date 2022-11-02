package com.feg.newcoder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Feg
 * @version 1.0
 * 我就问你我这题牛逼不
 * 解决了treemap以value排序的问题，以及重复value的问题
 */
public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Object[],Integer> map;

        // 注意 hasNext 和 hasNextLine 的区别
        int sum = in.nextInt();
        int sorted = in.nextInt();
        if(sorted == 1){
            map = new TreeMap<>((m,n) -> (int)m[1] - (int)n[1] == 0 ? 1 : (int)m[1] - (int)n[1]);
        } else{
            map = new TreeMap<>((m,n) -> (int)n[1] - (int)m[1] == 0 ? 1 : (int)n[1] - (int)m[1]);
        }
        for(int i=0;i<sum;i++){
            map.put(new Object[]{in.next(),in.nextInt()},1);
        }
        ArrayList<Object[]> list = new ArrayList<>(map.keySet());
        for(int i=0;i<sum;i++){
            Object[] arr = list.get(i);
            System.out.println(arr[0] + " " + arr[1]);
        }

    }
}
