package com.feg.leetcode;

import java.util.Arrays;

/**
 * @author Feg
 * @version 1.0
 */
public class Question344 {
    public static void main(String[] args) {
        String s = "hello";
        Question344 question344 = new Question344();
        char[] chars = s.toCharArray();
        question344.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char temp = ' ';
        while (left<right){
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
