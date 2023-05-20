package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question7 {
    public int reverse(int x) {
        String tempStr = x+"";
        char[] array = tempStr.toCharArray();
        int i = 0;
        if ('-'==(array[0])){
            i++;
        }
        int j = array.length-1;
        char temp = 0;
        while (i<j){
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        try {
            return Integer.parseInt(String.valueOf(array));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
