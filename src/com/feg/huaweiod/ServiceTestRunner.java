package com.feg.huaweiod;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 */
public class ServiceTestRunner {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Integer[][] service_map = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            service_map[i] = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        }
        int target = in.nextInt() - 1;
        System.out.println(dfs(target, service_map));
    }

    public static int dfs(int k, Integer[][] service_map) {
        int time = 0;
        for (int i = 0; i < service_map[k].length; i++) {
            if (i != k && service_map[k][i] != 0) {
                // 这里要max的原因是当前服务可能依赖多个其他服务，但是其它服务可以同时启动，谁启动的需要时间最长则当前服务就需要多长时间
                time = Math.max(time, dfs(i, service_map));
            }
        }
        return service_map[k][k] + time;
    }
}
