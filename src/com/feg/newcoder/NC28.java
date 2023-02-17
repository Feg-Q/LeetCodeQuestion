package com.feg.newcoder;

/**
 * @author Feg
 * @version 1.0
 */
public class NC28 {
    public String minWindow (String S, String T) {
        // 记录最终长度，因为是先扩大窗口，因此初始值需要是int的最大值
        int result = 10001;
        // 记录最终子串的起始位置
        int start = 0;
        // 两个初始字符串的长度
        int sLength = S.length();
        int tLength = T.length();
        // 数组用来记录字符串T的各个字符的数量
        int[] chars = new int[128];
        for(int i=0;i<tLength;i++){
            chars[T.charAt(i)]++;
        }
        // l是窗口的左边界，r是右边界，count是还没有指到的字符数量，当为0的时候代表当前窗口已经满足了要求
        int l = 0,r = 0,count = tLength;
        while(r<sLength){
            // 这里的执行顺序很有讲究，先执行charAt，再执行++，先执行>判断，再执行--，所以判断要大于0
            if(chars[S.charAt(r++)]-- > 0){
                count--;
            }
            // count等于0代表所有的目标字符都已经找到（包含）
            while(count==0){
                //进来之后先更新子串的长度
                if(result > r-l){
                    result = r-l;
                    start = l;
                }
                // 此时在l到r的窗口内，包含了目标字符的数组值为0，不包含的都是负数，因此找到第一个是0的位置即当前窗口内的最小子字符串
                if(chars[S.charAt(l++)]++ == 0){
                    count++;
                }
            }
        }
        // 如果result还是初始值，那表明没有找到满足要求的子字符串，则返回""
        return result == 10001 ? "" : S.substring(start,start + result);
    }
}
