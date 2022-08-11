package com.feg.leetcode.question101_200;

/**
 * @author Feg
 * @version 1.0
 * 思路还是没有清晰，应该尽量避免多重循环
 */
public class Question167 {
    //这种方法妙啊，执行用时1ms，我自己写的500ms。
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0,j=numbers.length-1;i<j; ){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                return new int[] {i+1,j+1};
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
    //下面的是我自己一开始想的方法，用了双循环，用时500ms。
    /*
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    result[0]=i+1;
                    result[1]=j+1;
                    flag = true;
                    break;
                }
                if(numbers[i]+numbers[j]>target){
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return result;
    }
    */
}
