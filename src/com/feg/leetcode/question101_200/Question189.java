package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 * 看了评论瞬间明白了这种方法
 */
public class Question189 {
    public void reverse(int[] arr,int s,int e){
        int temp;
        for(int start = s,end = e;start<=(start+end)/2;start++,end--){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k>=length){
            k = k%length;
        }
        reverse(nums,0,length-k-1);
        reverse(nums,length-k,length-1);
        reverse(nums,0,length-1);
    }
}
