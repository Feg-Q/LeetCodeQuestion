package leetcode.question1_100;

import java.util.HashMap;

/**
 * @author Feg
 * @version 1.0
 */
public class Question72 {
    // 先用递归的思路做
    public int minDistance(String word1, String word2) {
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    // dp递归函数，定义为字符串1的前i项到字符串2的前j项的最小编辑距离
    public int dp(String word1, int i, String word2, int j) {
        // base case情况
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        String key = i + " " + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 四种情况，什么都不做、增加、删除、修改
        int res;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = dp(word1, i - 1, word2, j - 1);
        } else {
            res = min(dp(word1, i, word2, j - 1) + 1, dp(word1, i - 1, word2, j) + 1, dp(word1, i - 1, word2, j - 1) + 1);
        }
        memo.put(key, res);
        return res;
    }

    public int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    // 再用动态规划的备忘录，即dp数组减少重复计算
    public int dp(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // 定义dp数组是表示字符串1的前i项转换成字符串2的前j项的最小编辑距离
        int[][] dpTable = new int[length1 + 1][length2 + 1];
        // dp数组的初始化
        for (int i = 0; i <= length1; i++) {
            dpTable[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            dpTable[0][i] = i;
        }
        // 遍历
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不做任何操作
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    // 添加、删除、修改三种操作取最小值
                    dpTable[i][j] = min(dpTable[i][j - 1] + 1, dpTable[i - 1][j] + 1, dpTable[i - 1][j - 1] + 1);
                }
            }
        }
        return dpTable[length1][length2];
    }
}
