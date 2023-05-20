package com.feg.leetcode.question1_100;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Feg
 * @version 1.0
 * n皇后问题
 */
public class Question51 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化一个棋盘，用二维数组表示
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board,0);
        return result;
    }
    public void backtrack(char[][] board,int row){
        // 深度优先搜索的结束条件
        if (row == board.length){
            result.add(change(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board,row,i)){
                // 做选择
                board[row][i] = 'Q';
                // 下一行
                backtrack(board, row + 1);
                // 撤销选择
                board[row][i] = '.';
            }
        }
    }
    // 检查位置[row][col]放置了皇后后是否满足要求
    public boolean isValid(char[][] board, int row, int col) {
        // 检查同一列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左下斜线
        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右下斜线
        for (int i = row - 1,j = col + 1; i >= 0 && j < board[0].length; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    };
    public List<String> change(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                stringBuilder.append(board[i][j]);
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }
}
