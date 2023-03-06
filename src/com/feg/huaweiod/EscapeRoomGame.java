package com.feg.huaweiod;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Feg
 * @version 1.0
 */
public class EscapeRoomGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        TreeSet<Character> common = new TreeSet<>();
        for (char c : key.toCharArray()) {
            common.add(c);
        }
        String left = common.toString();
        TreeSet<Character> temp = new TreeSet<>();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            char[] chars = string.toLowerCase().toCharArray();
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z'){
                    temp.add(aChar);
                }
            }
            if (temp.toString().equals(left)){
                System.out.println(i + 1);
                return;
            } else {
                temp.clear();
            }
        }
        System.out.println(-1);
    }
}
