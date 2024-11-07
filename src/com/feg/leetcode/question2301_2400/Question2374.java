package com.feg.leetcode.question2301_2400;

/**
 * @author Feg
 * @createDate 2024/9/21 17:23
 * @description
 */
public class Question2374 {

    public static void main(String[] args) {
        int[] edges = {1,0,0,0,0,7,7,5};
        System.out.println(new Question2374().edgeScore(edges));
    }
    
    public int edgeScore(int[] edges) {
        int res = 0;
        long max = 0;
        long[] result = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int value = edges[i];
            result[value] += i;
            if (result[value] > max || result[value] == max && value < res) {
                res = edges[i];
                max = result[value];
            }
        }
        return res;
    }
}
