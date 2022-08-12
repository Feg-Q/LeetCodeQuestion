package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 感动，第四次提交终于过了，第一次卡在单字符"a"，第二次卡在"ac"，第三次卡在不是最长的（""aacabdkacaa""）,
 * 考虑了一下不在循环中直接返回，而是记下符合要求的左右两侧值，再继续循环再找，找到的比较长度，结果就是执行用时很高，
 * 还可以优化
 */
public class Question5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Question5().longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j >i ; j--) {
                boolean flag = true;
                if (array[j]==array[i]){
                    int left = i+1;
                    int right = j-1;
                    while(left<right){
                        if (array[right]==array[left]) {
                            left++;
                            right--;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if (flag&&(j-i)>(range[1]-range[0])){
                        range[0] = i;
                        range[1] = j;
                    }
                }
            }
        }
        return s.substring(range[0],range[1]+1);
    }
    //这个是在评论区复制别人的解答
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //把回文看成中间的部分全是同一字符，左右部分相对称
            //找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        //查找中间部分（即一个奇数子串的中间的那个字母或者一个偶数子串的中间两个字母）
        int high = low;
        //下面这个while循环是为了解决回文子串中间的几个字母相同的问题，
        //将high赋值为相同字母的最后一个
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        //从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        //返回当前回文子串的中间部分的最后一个字母是因为
        // 在一个已经确定的回文子串的中间部分的其它字母为中心都不可能是回文子串
        return ans;
    }
}
