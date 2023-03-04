package com.feg.huaweiod;

import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class ChargingStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        int maxTarget = scanner.nextInt();
        int[][] dpTable = new int[count + 1][maxTarget + 1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= maxTarget; j++) {
                if (nums[i-1] > j){
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i-1][j-nums[i-1]] + nums[i-1]);
                }
            }
        }
        System.out.println(dpTable[count][maxTarget]);
    }
}
