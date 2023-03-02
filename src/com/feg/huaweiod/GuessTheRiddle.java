package com.feg.huaweiod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class GuessTheRiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] split1 = line1.split(",");
        String line2 = scanner.nextLine();
        String[] split2 = line2.split(",");
        ArrayList<String> res = new ArrayList<>();
        for (String s1 : split1) {
            for (String s2 : split2) {
                char[] chars1 = s1.toCharArray();
                char[] chars2 = s2.toCharArray();
                // 去重后是否一致
                ArrayList<Character> list1 = new ArrayList<>();
                ArrayList<Character> list2 = new ArrayList<>();
                for (char c : chars1) {
                    if (!list1.contains(c)){
                        list1.add(c);
                    }
                }
                for (char c : chars2) {
                    if (!list2.contains(c)){
                        list2.add(c);
                    }
                }
                if (list1.toString().equals(list2.toString())){
                    res.add(s2);
                    continue;
                }
                // 变换顺序后是否一致
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                if (Arrays.equals(chars1,chars2)){
                    res.add(s2);
                    continue;
                }
                res.add("not found");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}
