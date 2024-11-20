package com.feg.leetcode.question1_100;

/**
 * @author Feg
 * @createDate 2024/11/20 09:15
 * @description
 */
public class Question79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new Question79().exist(board, "ABCESEEEFS"));
    }
    
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] isUsed;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isUsed = new boolean[board.length][board[0].length];
                    res = res || dfs(board, word, 0, i, j, isUsed);
                    System.out.println();
                }
            }
        }
        return res;
    }
    
    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] isUsed) {
        if (index >= word.length()) {
            return true;
        }
        // 先判断是否超出二维数组边界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (isUsed[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        // 选择
        isUsed[x][y] = true;
        System.out.println(board[x][y]);
        boolean res = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 && j == 0) || (i != 0 && j != 0)) continue;
                boolean dfs = dfs(board, word, index + 1, x + i, y + j, isUsed);
                res = res || dfs;
            }
        }
        // 如果此点不是答案，则一定记得回溯
        if (!res) {
            isUsed[x][y] = false;
        }
        return res;
    }
}
