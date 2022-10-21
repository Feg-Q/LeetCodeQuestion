package com.feg.剑指offerll;

/**
 * @author Feg
 * @version 1.0
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Question05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            if (' ' == aChar){
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(aChar);
            }
        }
        return stringBuffer.toString();
    }
}
