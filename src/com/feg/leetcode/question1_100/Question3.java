package com.feg.leetcode.question1_100;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 感动，错了八次了终于做出来了，虽然还是暴力解法，以后优化吧
 */
public class Question3 {
    public static void main(String[] args) {
        String s = "abdfbaceg";
        System.out.println(new Question3().lengthOfLongestSubstring2(s));
    }
    //自己最初写算法题的时候写的解答（98ms）
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=1){
            return s.length();
        }
        byte[] bytes = s.getBytes();
        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            HashMap hm = new HashMap<Byte,Integer>();
            for (int j = i; j < s.length(); j++) {
                byte aByte = bytes[j];
                if ((hm.get(aByte))!=null){
                    if (j-i>result){
                        result = j-i;
                    }
                    break;
                }else {
                    if (i!=s.length()-1&&j==s.length()-1){
                        int s1 = j-i+1;
                        if (s1>result){
                            result = s1;
                        }
                    }
                    hm.put(aByte,j);
                }

            }
        }
        return result;
    }
    //学了滑动窗口算法后写的（4ms）
    public int lengthOfLongestSubstring2(String s){
        //定义左右指针
        int left = 0;
        int right = 0;
        //定义变量来记录最长长度，初始赋为零。
        int endLength = 0;
        //定义一个集合来记录这个子串中的元素，通过添加元素和移除元素来让窗口往后滑动
        ArrayList<Character> list = new ArrayList<>();
        //将字符串转为字符数组便于操作
        char[] chars = s.toCharArray();
        //开始窗口滑动
        while (right<s.length()){
            char rightChar = chars[right];
            right++;
            //当前字符重复，则执行下面一些逻辑
            if (list.contains(rightChar)){
                //判断当前子串（还未重复）的长度，来更新最长无重复子串长度
                //-1是因为右指针在当前字符的右边一位
                if (right - left - 1 > endLength){
                    endLength = right - left - 1;
                }
                //当前字符已经重复，开始滑动左指针，直到排除了以前加入的这个重复的字符
                while (left<right){
                    char leftChar = chars[left];
                    list.remove(0);
                    left++;
                    //当前左字符是重复右字符，则停止移动左指针，此时子串仍是无重复的
                    if (leftChar == rightChar){
                        list.add(rightChar);
                        break;
                    }
                }
            }
            //当前字符在当前子串中不重复，则将其添加到子串集合中
            else {
                list.add(rightChar);
            }
            //最后重复右指针的移动，重复操作直到全部遍历
        }
        //排除右指针遍历到最后一个仍然是无重复子串的情况
        return Math.max(endLength,list.size());
    }
}
