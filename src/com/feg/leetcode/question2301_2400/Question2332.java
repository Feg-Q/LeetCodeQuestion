package com.feg.leetcode.question2301_2400;

import java.util.Arrays;

/**
 * @author Feg
 * @createDate 2024/9/18 22:10
 * @description
 */
public class Question2332 {

    public static void main(String[] args) {
        int[] buses = {20,30,10};
        int[] passengers = {19,13,26,4,25,11,21};
        System.out.println(new Question2332().latestTimeCatchTheBus(buses, passengers, 2));
    }
    
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int right = 0;
        int space = 0;
        for (int bus : buses) {
            space = capacity;
            while (space > 0 && right < passengers.length && passengers[right] <= bus) {
                space--;
                right++;
            }
        }
        right--;
        int result = passengers[right];
        // 此时right到达最后一辆车的最后一个位置
        if (space > 0) {
            result = buses[buses.length - 1];
        }
        while (right >= 0 && passengers[right] == result) {
            right--;
            result--;
        }
        return result;
    }
}
