package com.feg.huaweiod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class SymmetricString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<int[]> input = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            input.add(new int[]{scanner.nextInt(),scanner.nextInt()});
        }
        for (int[] ints : input) {
            int res = dfs(ints[0],ints[1] + 1);
            if (res == 0){
                System.out.println("blue");
            } else {
                System.out.println("red");
            }
        }
    }
    public static int dfs(int n,int k){
        // 递归到第二层，可以判断了，0表示B，1表示R
        if (n == 2){
            return k - 1;
        }
        int count = 1 << n-1;
        if (k > count/2) {
            return dfs(n-1,k-count/2);
        } else {
            int res = dfs(n-1,k);
            if (res == 1){
                return 0;
            } else {
                return 1;
            }
        }
    }
}
