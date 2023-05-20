package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question9 {
    public boolean isPalindrome(int x) {
        String temp = x+"";
        char[] array = temp.toCharArray();
        int i=0;
        int j=array.length-1;
        while (i<j){
            if (array[i]!=array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
