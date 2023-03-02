package com.feg.huaweiod;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class PerfectWalker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        // 每种字符应该出现的次数
        int average = inputStr.length() / 4;
        // 定义两个map，第一个存储整个字符串中每个字符出现的次数，第二个存储初始左右区间中各个字符的个数
        Map<Character,Integer> countMap = new HashMap<>();
        Map<Character,Integer> currentMap = new HashMap<>();
        // 遍历整个字符，记录各字符个数
        for (int i = 0; i < inputStr.length(); i++) {
            // 到了初始右指针的位置，记录下此时左右区间中的各字符个数
            if (i == average) {
                // 注意如果某个字符不存在就默认为0
                currentMap.put('W',Optional.ofNullable(countMap.get('W')).orElse(0));
                currentMap.put('A',Optional.ofNullable(countMap.get('A')).orElse(0));
                currentMap.put('S',Optional.ofNullable(countMap.get('S')).orElse(0));
                currentMap.put('D',Optional.ofNullable(countMap.get('D')).orElse(0));
            }
            char key = inputStr.charAt(i);
            Integer keyCount = countMap.get(key);
            countMap.put(key,keyCount == null ? 1 :keyCount + 1);
        }
        // 定义每个字符需要在这个区间中出现几次，如果是正数，表示需要出现，负数不需要管
        int needW = Optional.ofNullable(countMap.get('W')).orElse(0) - average;
        int needA = Optional.ofNullable(countMap.get('A')).orElse(0) - average;
        int needS = Optional.ofNullable(countMap.get('S')).orElse(0) - average;
        int needD = Optional.ofNullable(countMap.get('D')).orElse(0) - average;
        // 左指针
        int left = 0;
        // 初始右指针
        int right = average - 1;
        // 记录最终答案的值
        int res = Integer.MAX_VALUE;
        // 循环完成之后必然是某一个指针碰到右边界
        while (true) {
            // 如果这个区间满足了要求，那就左指针右移一位
            if (currentMap.get('W') >= needW && currentMap.get('A') >= needA && currentMap.get('S') >= needS && currentMap.get('D') >= needD){
                // 更新区间最小值
                res = Math.min(res,right - left + 1);
                char leftChar = inputStr.charAt(left);
                // 把left指针对应的字符个数减一
                currentMap.put(leftChar,currentMap.get(leftChar) - 1);
                // 移动左指针，如果碰到边界就直接跳出循环
                if (++left == inputStr.length()){
                    break;
                }
                continue;
            }
            // 右指针越界，直接结束循环
            if (++right == inputStr.length()){
                break;
            }
            // 把右指针对应的字符个数加一
            char rightChar = inputStr.charAt(right);
            currentMap.put(rightChar,currentMap.get(rightChar) + 1);
        }
        System.out.println(res);
    }
}
