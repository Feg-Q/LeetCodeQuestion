package com.feg.leetcode.question201_300;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2025/4/1 10:34
 * @description h指数
 */
public class Question274 {
    
    public int hIndex(int[] citations) {
        int length = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) {
                return length - i;
            }
        }
        return 0;
    }
}
