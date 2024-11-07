package com.feg.leetcode.question901_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feg
 * @createDate 2024/9/22 22:09
 * @description
 */
public class Question997 {

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        int res = -1;
        Map<Integer, Integer> countMap = new HashMap<>(n);
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int[] trs : trust) {
            map.put(trs[0], trs[1]);
            Integer count = countMap.getOrDefault(trs[1], 0);
            count += 1;
            countMap.put(trs[1] , count);
            if (count == n -1) {
                res = trs[1];
            }
        }
        return map.get(res) == null ? res : -1;
    }
}
