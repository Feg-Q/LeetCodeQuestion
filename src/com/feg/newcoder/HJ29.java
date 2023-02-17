package com.feg.newcoder;

import java.util.Scanner;

/**
 * 字符串加密解谜问题
 * @author Feg
 * @version 1.0
 */
public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        StringBuilder builder = new StringBuilder();
        //加密
        for(int i = 0;i<s1.length();i++){
            char c = s1.charAt(i);
            if(c > 96){ //该字符是小写字母的情况
                builder.append((char)(c-31) < 91 ? (char)(c-31) : (char)(c-57) +"");
            } else if(c > 64) { //该字符是大写字母的情况
                builder.append((char)(c+33) < 123 ? (char)(c+33) : (char)(c+7) + "");
            } else{ //该字符是数字的情况
                builder.append((c - 47) % 10 + "");
            }
        }
        String result1 = builder.toString();
        builder = new StringBuilder();
        //解谜
        for(int i=0;i<s2.length();i++){
            char x = s2.charAt(i);
            if(x > 96){ //该字符是小写字母的情况
                builder.append((char)(x-33) > 64 ? (char)(x-33) : (char)(x-7) + "");
            } else if (x > 64){ //该字符是大写字母的情况
                builder.append((char)(x+31) > 96 ? (char)(x+31) : (char)(x+57) + "");
            } else { //该字符是数字的情况
                builder.append((x-49) > -1 ? (x-49) : (x-39)+"");
            }
        }
        System.out.println(result1);
        System.out.println(builder.toString());
    }
}
