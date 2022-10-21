package com.feg.newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        //new HJ33().two();
        long r = 167969729;
        System.out.println(r >> 8);
        System.out.println( r % 256);
    }
    public void one(){
        Scanner in = new Scanner(System.in);
        // 输入了两行字符串，用list保存
        List<String> list = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        int j = 0;
        while(j++ < 2){
            String input = in.nextLine();
            list.add(input);
        }
        // 处理第一个字符串，ip转数字
        // 用"."分割字符串，注意.要转义
        String[] ss = list.get(0).split("\\.");
        long result = 0;
        for(int i=0;i<4;i++){
            result = result << 8 + Integer.parseInt(ss[i]);
        }
        System.out.println(result);
        // 处理第二个
        long ip = Long.parseLong(list.get(1),10);
        String resultStr = "";
        for(int i=0;i<4;i++){
            resultStr = (ip >> 8) + "." + resultStr;
            ip /= 256;
        }
        System.out.println(resultStr.substring(0,resultStr.length()-1));
    }
    // 看了别人的题解写出来的
    public void two(){
        Scanner in = new Scanner(System.in);
        // 输入了两行字符串，用list保存
        List<String> list = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        int j = 0;
        while(j++ < 2){
            String input = in.nextLine();
            list.add(input);
        }
        // 处理第一个字符串，ip转数字
        // 用"."分割字符串，注意.要转义
        String[] ss = list.get(0).split("\\.");
        long result = 0;
        // 点睛之笔，但是乘以256不知道为什么左移8位不行
        for(int i=0;i<4;i++){
            result = (result << 8) + Integer.parseInt(ss[i]);
        }
        System.out.println(result+"");
        // 处理第二个
        long ip = Long.parseLong(list.get(1));
        String resultStr = "";
        for(int i=0;i<4;i++){
            resultStr = ip % 256 + "." + resultStr;
            ip /= 256;
        }
        System.out.println(resultStr.substring(0,resultStr.length()-1));
    }
}