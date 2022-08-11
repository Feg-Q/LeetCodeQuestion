package com.feg.leetcode.question1_100;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * n皇后问题
 */
public class Question51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> list = new ArrayList<>(n);
        for (int i = 0; i < list.size(); i++) {
            list.add(".");
        }
        backtrack(list,0);
        return result;
    }
    public void backtrack(List<String> list,int row){
        if (row == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < list.size(); i++) {

        }
    }
//    public boolean isValid();
}
