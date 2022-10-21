package com.feg.剑指offerll;

/**
 * @author Feg
 * @version 1.0
 * 判断一个字符串是否是数值
 */
public class Question20 {
    public static void main(String[] args) {
        String s = "1. ";
        System.out.println(new Question20().isNumber(s));
    }
    public boolean isNumber(String s) {
        String upperCase = s.toUpperCase();
        int start = 0;
        while (start < s.length() && upperCase.charAt(start) == ' '){
            start++;
        }
        String s1 = upperCase.substring(start);
        int e = s1.indexOf('E');
        if (e == -1){
            int i = s1.indexOf('.');
            if (i == -1){
                return isAllNum(s1);
            } else {
                return isFloat(s1);
            }
        } else {
            if (e == 0 || e == s1.length()-1){
                return false;
            }
            boolean left = isFloat(s1.substring(0, e));
            boolean right = isAllNum(s1.substring(e + 1));
            return left && right;
        }
    }
    public static boolean isFloat(String s){
        String s1 = s;
        char charAt = s1.charAt(0);
        if (charAt == '+' || charAt == '-'){
            if (s.length() < 2){
                return false;
            }
            s1 = s.substring(1);
        }
        int index = s1.indexOf('.');
        if (index == -1){
            return isAllNum(s1);
        } else {
            if (index == 0){
                return isAllNum(s1.substring(1));
            }
            if (index == s1.length()-1){
                return isAllNum(s1.substring(0,index));
            }
            boolean leftAllNum = isAllNum(s1.substring(0, index));
            boolean rightAllNum = isAllNum(s1.substring(index + 1));
            return leftAllNum && rightAllNum;
        }
    }

    // 判断一个字符串是否是整数
    public static boolean isAllNum(String s){
        s = s.trim();
        if (s.length() < 1 ){
            return false;
        }
        char[] chars = s.toCharArray();
        // 如果第一位是+或-，就改成数字，不影响后续判断
        if (chars[0] == '+' || chars[0] == '-'){
            if (s.length() == 1){
                return false;
            }
            chars[0] = '1';
        }
        for (int i = 0; i < chars.length - 1; i++) {
            char aChar = chars[i];
            if (aChar == ' ' && chars[i+1] == ' '){
                continue;
            }
            if (aChar < '0' || aChar > '9'){
                return false;
            }
        }
        char aChar = chars[chars.length - 1];
        return aChar == ' ' || (aChar >= '0' && aChar <= '9');
    }
}
