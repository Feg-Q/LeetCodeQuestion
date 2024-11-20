package com.feg.leetcode.question3201_3300;

/**
 * @author Feg
 * @createDate 2024/11/20 10:02
 * @description
 */
public class Question3244 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        int res = n - 1;
        int[] del = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            del[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int cur = del[query[0]];
            while (cur != -1 && cur < query[1]) {
                int temp = del[cur];
                del[cur] = -1;
                cur = temp;
                res--;
            }
            del[query[0]] = query[1];
            result[i] = res;
        }
        return result;
    }
}
