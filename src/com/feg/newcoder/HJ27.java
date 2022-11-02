package com.feg.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        int sum = in.nextInt();
        for(int i=0;i<sum;i++){
            list.add(in.next());
        }
        String str = in.next();
        int num = in.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<sum;i++){
            String s = list.get(i);
            if(str.equals(s) || str.length() != s.length()){
                continue;
            }
            char[] c1 = s.toCharArray();
            char[] c2 = str.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            if((new String(c1).equals(new String(c2)))){
                arr.add(s);
            }
        }
        if(arr.size() == 0){
            System.out.println(0);
            return;
        }
        arr.sort((i,j) -> i.compareTo(j));
        int size = arr.size();
        System.out.println(size);
        if(size<num){
            return;
        }
        System.out.println(arr.get(num-1));
    }
}
