package com.feg.leetcode.question2301_2400;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Feg
 * @createDate 2024/9/20 19:47
 * @description 题目描述很简单，一个数字的每个位置如果都不相同，则认为是特殊整数，给出一个n，计算小于n的特殊整数的个数
 * 这道题目算是有模板的，因为是对于一个数字的每个位置的处理，因此可以用数位DP
 * 采用递归的方法，核心是先定义dfs函数的参数，首先从左到右遍历，参数i表示当前遍历到第i个位置，之后需要一个数组used表示前面已经选择过的数字，
 * 到这里可以先写出函数定义，开始写逻辑
 */
public class Question2376 {

    public static void main(String[] args) {
        System.out.println(new Question2376().countSpecialNumbers(172983981));
    }
    
    public int countSpecialNumbers(int n) {
        int[][] memo = new int[String.valueOf(n).length()][1 << 10];
        for (int[] row : memo) {
            // -1 表示没有计算过
            Arrays.fill(row, -1); 
        }
        return dfs3(0, 0, String.valueOf(n), true, true, memo);
    }
    
    public int dfs1(int i, Set<Integer> used, String str, boolean isLimit) {
        // 首先判断当前选择位置是不是已经超过最大位数了
        if (i == str.length()) {
            return 0;
        }
        // 定义一个res结果，表示从当前位置往后，可行的方案总数
        int res = 0;
        // 开始遍历，一般是从0到9遍历，然后进入递归，但是按照逻辑，如果前面一位数字选择的和n的对应位置一样，则当前位置也不能超过n的对应位，反之可以0 - 9
        // 因此需要一个标记来记录上面一位是否选择了可选最大值，使用Boolean值isLimit
        int down = 0;
        int up = isLimit ? str.charAt(i) - '0' : 9;
        // 进入遍历
        for (int k = down; k < up; k++) {
            // 当前位置往后的总方案数，是后面一位从0 - 9遍历结果的加和
            used.add(k);
            res += dfs1(i + 1, used, str, isLimit && k == up - 1);
        }
        return res;
    }

    /**
     * 之后开始优化上述递归函数，上面的函数是一定错误的，因为还有情况没考虑到，且因为数组参数的传递性，会造成used数组前面选择的干扰后面选择的
     * 1. 防止干扰的话可以回溯取消当前数字的选择，也可以使用位运算来代替数组。因为数组中只会有0 - 9这10个数字，因此可以用长度为10的字符串来表示第i位这个数字i是否存在
     * 2. 需要考虑前导零的情况，即如果第一位选择了0，则后面的可以任意选，其中0也是可以选择的，比如010这个数字是符合的，但是按照代码逻辑就不符合了
     *    因此这种情况也需要一个标记来记录前面所有位置是否都是0，如果都是0，则当前位置有两种情况，其一同样选择0，其二正常选择 1 - 9(这里因为前面一个是0，所以当前位置无限制)
     */
    public int dfs2(int i, Set<Integer> used, String str, boolean isLimit, boolean isZero) {
        // 首先判断当前选择位置是不是已经超过最大位数了
        if (i == str.length()) {
            return isZero ? 0 : 1;
        }
        // 定义一个res结果，表示从当前位置往后，可行的方案总数
        int res = 0;
        // 如果前面都是0，则先选择跳过的方案，后面再选择正常
        if (isZero) {
            res = dfs2(i + 1, used, str, false, true);
        }
        // 开始遍历，一般是从0到9遍历，然后进入递归，但是按照逻辑，如果前面一位数字选择的和n的对应位置一样，则当前位置也不能超过n的对应位，反之可以0 - 9
        // 因此需要一个标记来记录上面一位是否选择了可选最大值，使用Boolean值isLimit
        int down = isZero ? 1 : 0;
        int up = isLimit ? str.charAt(i) - '0' : 9;
        // 进入遍历
        for (int k = down; k <= up; k++) {
            // 当前位置往后的总方案数，是后面一位从0 - 9遍历结果的加和
            if (used.contains(k)) {
                continue;
            }
            used.add(k);
            res += dfs2(i + 1, used, str, isLimit && k == str.charAt(i) - '0', false);
        }
        return res;
    }

    /**
     * 上面方法2是会超时的，因此还要加上记忆化搜索，即用一个数组来记住某个位置选择某个数字之后的结果，之后计算就直接获取
     * 这里是一个二维数组，第一维表示第i个位置，第二个位置表示选择哪个数字，这里因为一个只包含0 - 9的数组可以用一个单独的数字表示，因此第二个位置就是这个数字
     * 再者根据定义，如果当前位置有限制，则前面几位数字必定固定为原数字，这样的情况只可能出现一次，因此不必缓存，同理，全是前导零的情况也是。
     */
    public int dfs3(int i, int mark, String str, boolean isLimit, boolean isZero, int[][] memo) {
        // 首先判断当前选择位置是不是已经超过最大位数了
        if (i == str.length()) {
            return isZero ? 0 : 1;
        }
        if (!isLimit && !isZero && memo[i][mark] != -1) {
            return memo[i][mark];
        }
        // 定义一个res结果，表示从当前位置往后，可行的方案总数
        int res = 0;
        // 如果前面都是0，则先选择跳过的方案，后面再选择正常
        if (isZero) {
            res = dfs3(i + 1, mark, str, false, true, memo);
        }
        // 开始遍历，一般是从0到9遍历，然后进入递归，但是按照逻辑，如果前面一位数字选择的和n的对应位置一样，则当前位置也不能超过n的对应位，反之可以0 - 9
        // 因此需要一个标记来记录上面一位是否选择了可选最大值，使用Boolean值isLimit
        int down = isZero ? 1 : 0;
        int up = isLimit ? str.charAt(i) - '0' : 9;
        // 进入遍历
        for (int k = down; k <= up; k++) {
            // 当前位置往后的总方案数，是后面一位从0 - 9遍历结果的加和
            if ((mark >> k & 1) != 0) {
                continue;
            }
            res += dfs3(i + 1, mark | 1 << k, str, isLimit && k == str.charAt(i) - '0', false, memo);
        }
        if (!isLimit && !isZero) {
            memo[i][mark] = res;
        }
        return res;
    }
}
