package com.feg.huaweiod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @version 1.0
 */
public class ArrayBuilder {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int right = scanner.nextInt();
        int left = right - collect.get(0);
        for (int i = 0; i < list.size(); i++) {
            res(list,i,0,left,right);
        }
        System.out.println(count);

    }
    public static void res(List<Integer> list,int index,int sum,int left,int right){
        int temp = sum + list.get(index);
        if (temp > left && temp <= right) {
            count++;
            return;
        }
        if (temp > right){
            return;
        }
        for (int i = index; i < list.size(); i++) {
            res(list, i, temp, left, right);
        }

    }
}
