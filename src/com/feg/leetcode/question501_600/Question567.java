package leetcode.question501_600;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 字符串s2是否包含s1的任意排列
 * 这题相较于76题的区别是窗口内的字符的类别和个数必须和s1保持一致，不能有其它字符或者多余的字符。
 * 原本我以为只要移动右指针就行，而得出的结果除了包含s1的字符，还包含其它字符，不符合要求。
 * 后来想着当出现不符合要求的字符时就把用来界定结果的result置零，但出现了新的问题，
 * 这样只能对其它字符有效，如果是s1中的字符但是是多出的就不能解决。
 * 看了题解，意识到如果存在这样的子串，则子串的长度必然是s1的长度，则窗口的最小值就是这个长度，
 * 如果右指针移动后的窗口大小大于等于了这个长度，就缩小窗口，
 * 根据缩小后更新的各个判据的值再次计算，然后依次重复，一直保持窗口的大小为这个长度，
 * 则判断result符合时就一定是找到了符合要求的子串。
 *
 */
public class Question567 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int result = 0;
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer count = needMap.get(c);
            needMap.put(c,(count == null ? 1 : count+1));
        }
        char[] chars = s2.toCharArray();
        while (right<s2.length()){
            char aChar = chars[right];
            right++;
            if (needMap.containsKey(aChar)){
                Integer windowChar = windowMap.get(aChar);
                windowMap.put(aChar,(windowChar == null ? 1 : windowChar+1));
                if (windowMap.get(aChar).equals(needMap.get(aChar))){
                    result++;
                }
            }
            while (right - left >= s1.length()){
                if (result == needMap.size()){
                    return true;
                }
                char leftChar = chars[left];
                left++;
                if (needMap.containsKey(leftChar)){
                    if (windowMap.get(leftChar).equals(needMap.get(leftChar))){
                        result--;
                    }
                    windowMap.put(leftChar,windowMap.get(leftChar)-1);
                }
            }
        }
        return false;
    }
}
