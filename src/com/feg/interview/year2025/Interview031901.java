package com.feg.interview.year2025;

/**
 * @author Feg
 * @createDate 2025/3/19 15:10
 * @description 翻转字符串，很简单
 */
public class Interview031901 {
    
    public static void main(String[] args) {
        String input = "hello world";
        char[] charArray = input.toCharArray();
        char temp;
        int length = charArray.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        System.out.println(String.valueOf(charArray));
    }
}
