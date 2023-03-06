package com.feg.huaweiod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @version 1.0
 */
public class Question41 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 两个for循环遍历所有的连续子数组
        for (int i = 0; i < N; i++) {
            int count = nums.get(i);
            for (int j = i; j < N; j++) {
                int[] temp = {i, j};   // 首坐标i，尾座标j
                if (i != j) {
                    count += nums.get(j);
                }
                if (map.containsKey(count)) {
                    map.get(count).add(temp);
                } else {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.add(temp);
                    map.put(count, tempList);
                }
            }
        }
        int res = 0;
        for (List<int[]> list : map.values()) {
            res = Math.max(res, removeIntersect(list));
        }
        System.out.println(res);
    }

    // 排除有交集的连续子数组情况
    public static int removeIntersect(List<int[]> list) {
        int max = 0;
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < list.size(); i++) {
            // 用来保存以i位置的元素为基准的不重叠的子序列
            List<int[]> tempList = new ArrayList<>();
            tempList.add(list.get(i));
            int right = list.get(i)[1]; // 第一个序列的最后一个元素下标
            for (int j = i + 1; j < list.size(); j++) {
                int left = list.get(j)[0];
                if (left > right) {  // 没有交集
                    tempList.add(list.get(j));
                    right = list.get(j)[1];
                }
            }
            max = Math.max(max, tempList.size());
        }
        return max;
    }
}
