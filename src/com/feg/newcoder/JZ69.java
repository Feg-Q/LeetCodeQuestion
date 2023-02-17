package com.feg.newcoder;

/**
 * 跳台阶
 * @author Feg
 * @version 1.0
 */
public class JZ69 {
    public int jumpFloor(int target) {
        if(target<=2){
            return target;
        }
        int first = 1;
        int second = 2;
        int sum = 0;
        while(target-- > 2){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
