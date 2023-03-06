package com.feg.huaweiod;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author Feg
 * @version 1.0
 */
public class StringPuzzleSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        int a = (int)string2.chars().distinct().count();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        // 处理字符串1，去除干扰字符后将多个有效字符加入集合
        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            // 如果遇到无效字符
            if ((c >= 'a' && c <= 'f') || (c >= '0'&& c<='9')){
                // 判断此时StringBuilder是否为空，如果不为空，表明前面有有效字符串
                if (stringBuilder.capacity() != 0) {
                    // 把字符串添加进去并重新生成StringBuilder
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            } else { // 是有效字符，直接append
                stringBuilder.append(c);
            }
        }
        // 保证最后一个字符串也被处理
        if (stringBuilder.capacity() != 0) {
            list.add(stringBuilder.toString());
        }
        // 分别用来存储小于字符串2长度的最大字符串长度、字典序和、对应的字符串
        int maxCount = 0;
        int sum = 0;
        String temp = "";
        for (String s : list) {
            System.out.println(s);
            // 获取到s的字符流并去重
            IntStream intStream = s.chars().distinct();
            // 统计去重后的字符个数
            int count = (int)intStream.count();
            // 如果当前字符个数满足不大于条件
            if (count <= a){
                // 和已经记录的最大个数比较
                if (count >= maxCount){
                    // 比较字典序和
                    int curSum = s.chars().distinct().sum();
                    if (curSum > sum){
                        maxCount = count;
                        sum = curSum;
                        temp = s;
                    }
                }
            }
        }
        TreeSet<ArrayList<Integer>> set = new TreeSet<>();

        System.out.println(temp);
    }
}
