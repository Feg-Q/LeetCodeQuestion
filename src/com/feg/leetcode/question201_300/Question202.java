package com.feg.leetcode.question201_300;

import java.util.HashSet;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/5/30 9:26
 * 快乐数
 */
public class Question202 {
    public boolean isHappy(int n) {
        int newNum = n;
        HashSet<Integer> set = new HashSet<>();
        while (newNum != 1) {
            // 进行各位平方和
            int sum = 0;
            while (newNum != 0) {
                sum += Math.pow(newNum%10,2);
                newNum = newNum / 10;
            }
            if (set.contains(sum)) {
                break;
            }
            set.add(sum);
            newNum = sum;
        }
        return newNum == 1;
    }
}
