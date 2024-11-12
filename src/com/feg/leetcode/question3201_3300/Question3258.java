package com.feg.leetcode.question3201_3300;

/**
 * @author Feg
 * @createDate 2024/11/12 21:38
 * @description
 * 个人思路：双重循环，外层从头到尾遍历，内层从外层开始遍历，然后往后移动内层边界，同时计算数量，再判断符合要求，不符合的话就直接结束内层循环
 * 如此外层走完之后，即可得出答案。
 * 题解思路：以一个符合要求的最大窗口作为滑动的条件，如果固定右端点，则假设左端点最小可以是left，那么这个窗口内left可以递增都符合要求，
 * 也就是从right - left个数都符合要求，因此可以让right往后遍历，寻找一个最小的left，找到之后就累加答案，之后移动右端点，见答案2
 */
public class Question3258 {

    public static void main(String[] args) {
        System.out.println(new Question3258().countKConstraintSubstrings("10101", 1));
    }
    
    public int countKConstraintSubstrings(String s, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int[] num = new int[2];
        while (left < s.length()) {
            // 新的一个内循环
            right = left;
            num[0] = 0;
            num[1] = 0;
            // 内循环
            while (right < s.length()) {
                int index = s.charAt(right) - '0';
                num[index]++;
                if (num[index] > k && num[1 - index] > k) {
                    break;
                } else {
                    result++;
                }
                right++;
            }
            left++;
        }
        return result;
    }

    public int countKConstraintSubstrings2(String S, int k) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < s.length; i++) {
            cnt[s[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}