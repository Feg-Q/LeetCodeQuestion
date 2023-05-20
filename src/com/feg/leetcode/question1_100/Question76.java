package leetcode.question1_100;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 * 最小覆盖子串问题
 *
 * 思路：看了题解，大概理解了滑动窗口的思路
 *      维护一个处于左右指针之间的窗口，对窗口中的数进行判断，然后移动右指针扩大窗口，符合要求后移动左指针缩小窗口。
 * java中对于哈希表的处理比较繁琐，要想让一个键的值加一，还需要先获得这个值，然后加一后再添加到哈希表中。
 */
public class Question76 {

    public String minWindow(String s, String t) {
        //左右指针
        int left = 0;
        int right = 0;
        //定义一个计数来统计s中出现的t中包含的不同字符的个数，
        //即出现一个不同的字符就加一，最后全部出现就是窗口缩小的时候
        int count = 0;
        //用两个数据来记录最小子串的起始位置和长度
        int sta = 0;
        int length = s.length()+2;
        //两个HashMap用来记录字符串中的字符的出现次数
        HashMap<Character,Integer> window = new HashMap<>(),need = new HashMap<>();
        //初始化need哈希表的数据
        for (char c : t.toCharArray()) {
            Integer needChar = need.get(c);
            need.put(c,needChar == null ? 1 : needChar +1);
        }
        //将字符串s转变成字符数组便于获取单个字符
        char[] chars = s.toCharArray();
        //开始滑动窗口
        while (right<s.length()){
            char c1 = chars[right];
            right++;
            if (need.containsKey(c1)){
                Integer windowChar = window.get(c1);
                window.put(c1,windowChar == null ? 1: windowChar+1);
                windowChar = window.get(c1);
                if (windowChar.equals(need.get(c1))){
                    count++;
                }
            }
            //此时表明在当前子串中已经出现了目标t中的全部字符，可以开始收缩窗口
            while (count == need.size()){
                //这里有个问题，原本直接判断然后赋值，但是初始的length值是0，导致永远都没法赋值
                //然后把length初始值设置为s的长度，这样第一次判断必定可以赋值，
                //然而有了更大的问题，如果进不了这个循环，那么length的值最后就还是长度，就导致本应该返回空的返回了全部字符串。
                //所以就只能把length的值赋值为0，并在判断当前长度是否小于上一个length不通过的时候再判断一次length的值是否是0，
                //来弥补第一次赋值时的情况。
                //if (needLength<length){
                //       sta = left;
                //       length = needLength;
                //   }else {
                //       if (length == 0){
                //           sta = left;
                //           length = needLength;
                //       }
                //   }
                //但这样代码就复杂了，看了题解改了一下：
                //让length赋一个很大的值，最后返回结果的时候判断length是否还是这个值，
                // 如果是那就表明没有进入循环也就是没有符合要求的子串，否则就返回正常值

                //先记录下最小窗口的起始和长度
                int needLength =  right - left;
                if (needLength<length){
                    sta = left;
                    length = needLength;
                }
                //要移出去的字符
                char t1 = chars[left];
                left++;
                if (need.containsKey(t1)){
                    if (window.get(t1).equals(need.get(t1))){
                        count--;
                    }
                    window.put(t1,window.get(t1)-1);
                }
            }
        }
        return length == s.length()+2 ? "" : s.substring(sta,sta + length);
    }
}
