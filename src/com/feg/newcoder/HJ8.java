package com.feg.newcoder;

import java.util.*;

/**
 * @author Feg
 * @version 1.0
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> map = new TreeMap<>();
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        for(int i = 0;i < num;i++){
            int index = in.nextInt();
            if(map.containsKey(index)){
                map.put(index,map.get(index) + in.nextInt());
            } else {
                map.put(index,in.nextInt());
            }
        }
        Set<Integer> set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            int m = (int)it.next();
            System.out.println(m + " " + map.get(m));
        }
    }
}
