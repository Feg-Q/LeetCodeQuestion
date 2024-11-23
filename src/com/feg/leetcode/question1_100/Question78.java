package com.feg.leetcode.question1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2024/11/23 16:59
 * @description
 */
public class Question78 {

    public static void main(String[] args) {
        System.out.println(new Question78().subsets(new int[]{1, 2, 3}));
    }
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new boolean[nums.length], new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }
    
    public void dfs(int[] nums, int index, boolean[] isUsed, List<Integer> res) {
        if (index >=nums.length || isUsed[index]) {
            return;
        }
        res.add(nums[index]);
        isUsed[index] = true;
        result.add(new ArrayList<>(res));
        dfs(nums, index + 1, isUsed, res);
        res.remove(new Integer(nums[index]));
        isUsed[index] = false;
        dfs(nums, index + 1, isUsed, res);
    }
}
