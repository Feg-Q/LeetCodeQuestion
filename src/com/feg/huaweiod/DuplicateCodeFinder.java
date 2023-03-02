package com.feg.huaweiod;

import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class DuplicateCodeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int length1 = s1.length();
        int length2 = s2.length();
        // dp数组定义为以s1以i结尾的子串，和s2以j结尾的子串之间的最长重复长度，注意必须以i和j位为结尾
        int[][] dpTable = new int[length1 + 1][length2 + 1];
        int maxLength = 0;
        int right = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 如果这两个字符相等，那么以这两个字符为结尾的子串的最大长度就是前面的加一
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dpTable[i][j] = dpTable[i-1][j-1] + 1;
                    // 维护一个最大长度，每次有更新就判断是否有更长的，有就更新值并记录此时的右边界
                    if (dpTable[i][j] > maxLength){
                        maxLength = dpTable[i][j];
                        right = i - 1;
                    }
                }
                // 如果这两个字符不相等，那么以这两个位置为结尾的子串一定不可能重复，即是默认值0
            }
        }
        // 截取需要的子串，注意substring方法是左闭右开
        System.out.println(s1.substring(right-maxLength + 1, right + 1));
    }
}
