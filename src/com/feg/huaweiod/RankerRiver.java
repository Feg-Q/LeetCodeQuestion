package com.feg.huaweiod;

import java.util.Scanner;

/**
 * 士兵过河问题
 * @author Feg
 * @version 1.0
 */
public class RankerRiver {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int maxTime = scanner.nextInt();
        int[] a = new int[] {sum};
        for (int i = 0; i < sum; i++) {
            a[i] = scanner.nextInt();
        }
        int passedTime = 0;
        // 记录已经做过的选择
        boolean[] isRiver =  new boolean[sum];
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {

            }
        }
    }
    public static void riverCrossing(int[] a, int[] peoples, int passedTime, int requireTime, int maxTime) {
        // 结束条件
        if (passedTime + requireTime > maxTime){
            // 把当前已经过去的人数和需要的时间记录下来

            return;
        }
    }
}
