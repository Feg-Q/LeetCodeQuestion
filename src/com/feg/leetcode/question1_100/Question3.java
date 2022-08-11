package com.feg.leetcode.question1_100;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 感动，错了八次了终于做出来了，虽然还是暴力解法，以后优化吧
 */
public class Question3 {
    public static void main(String[] args) {
        String s = "aau";
        System.out.println(new Question3().lengthOfLongestSubstring(s));
    }
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
}
