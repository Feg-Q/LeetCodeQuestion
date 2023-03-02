package com.feg.huaweiod;

import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class BasketballScoreboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        for (int i = count; i > 0 ; i--) {
            if (dp(nums,i,sum)){
                break;
            }
        }
    }
    public static boolean dp(int[] nums,int k,int sum){
        if (sum % k != 0){
            return false;
        }
        return false;
    }
}
