package com.feg.huaweiod;

import java.util.Scanner;

/**羊狼过河问题，有m只羊，n只狼，船容量x，两岸羊的数量必须大于狼的数量
 * @author Feg
 * @version 1.0
 * 分析：1.特殊情况，开始的时候狼的数量比羊多，无解
 * 2.开始m>n，那就先移动狼，如果右岸狼的数量比船的一半容量还小，那就在剩下的位置运羊，即运了n只狼，x-n只羊
 */
public class SheepWolfRiverCrossing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int count = 0;
        // 如果初始时羊的个数就小于等于狼的个数，那必然无解
        if (m <= n){
            System.out.println(0);
            return;
        }
        // 初始时狼的数量比船的容量还少，则直接运走所有狼
        if (n < x) {

            if (n < (x + 1)/2){
                m -= x-n;
                count++;
            }
            count += (int)Math.ceil((double) m/x);
            return;
        }
        // 此时情况就是狼的数量比船的容量大，则应该先运过去x-1只狼，再运过去x只羊，之后循环每次狼和羊都运但羊比狼多一只
        n -= x-1;
        count++;
        m -= x;
        count++;
        int left = 1;
        // 开始循环运，
        int sleep = (x+1)/2;
        int wolf = x-sleep;
        while (m > 0){
            // 此岸的狼的个数已经比船的一半还少，则全运狼，剩下的运羊，然后运完剩下的羊
            if (n < wolf){
                m -= x-n;
                count++;
                count += (int)Math.ceil((double) m/x);
                System.out.println(count);
                return;
            }
            if (m - sleep > n - wolf){
                n -= wolf;
                m -= sleep;
                count++;
                left++;
            } else {
                int cha = left - 1;
                if (cha == 0){
                    System.out.println(0);
                    return;
                }
                n -= cha;
                left = 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
