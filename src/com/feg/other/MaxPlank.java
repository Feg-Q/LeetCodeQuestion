package com.feg.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Feg
 * @version 1.0
 */
public class MaxPlank {
    public static void main(String[] args) {
        int[] nums = {4,6,4,5,6};
        int max = max(5, 4, nums);
        System.out.println(max);
    }
    public static int max(int m,int n,int[] nums){
        int res = 0;
        IntStream stream = Arrays.stream(nums).sorted();
        ArrayList<Integer> arrayList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            int pre = arrayList.get(i-1);
            int temp;
            if ((temp = num - pre) < n){
                n -= temp;
                res = num;
            } else {
                break;
            }
        }
        return res;
    }

}
