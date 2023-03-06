package com.feg.huaweiod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Feg
 * @version 1.0
 */
public class DiscountShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumA = scanner.nextInt();
        int sumB = scanner.nextInt();
        int sumC = scanner.nextInt();
        int count = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextInt());
        }
        for (int integer : list) {
            // 对于每个人，从三种优惠中选择两个有6种方式，但无门槛满减肯定不能最先用，所以剩下4种。
            TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]){
                        return o2[1] - o1[1];
                    }else {
                        return o2[0] - o1[0];
                    }
                }
            });
            set.add(m1(integer,sumA));
            set.add(m2(integer,sumA));
            set.add(m3(integer,sumA,sumC));
            set.add(m4(integer,sumC));
            int[] res = set.pollLast();
            System.out.println(res[0] + " " + res[1]);
        }
    }
    // 先满减再打折
    public static int[] m1(int i,int sumA){
        int count = 0;
        while (sumA > 0){
            if (i < 100){
                break;
            }
            i -= (i/100) * 10;
            sumA--;
            count++;
        }
        count++;
        int[] res = {(int)(i*0.92),count};
        return res;
    }
    // 先打折再满减
    public static int[] m2(int i,int sumA){
        i = (int)(i * 0.92);
        int count = 1;
        while (sumA > 0){
            if (i < 100){
                break;
            }
            i -= (i/100) * 10;
            sumA--;
            count++;
        }
        int[] res = {i,count};
        return res;
    }
    // 先满减再无门槛
    public static int[] m3(int i,int sumA,int sumC){
        int count = 0;
        while (sumA > 0){
            if (i < 100){
                break;
            }
            i -= (i/100) * 10;
            sumA--;
            count++;
        }
        while (sumC > 0){
            i -= 5;
            sumC--;
            count++;
        }
        int[] res = {i,count};
        return res;
    }
    // 先打折再无门槛
    public static int[] m4(int i,int sumC){
        i = (int)(i * 0.92);
        int count = 1;
        while (sumC > 0){
            i -= 5;
            sumC--;
            count++;
        }
        int[] res = {i,count};
        return res;
    }
}
