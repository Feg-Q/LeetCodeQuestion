package com.feg.interview.year2025;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @createDate 2025/3/19 15:57
 * @description 全排列
 */
public class Interview031902 {
    
    private static List<List<Integer>> result = new ArrayList<>();
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        boolean[] isUsed = new boolean[nums.length];
        Interview031902 interview = new Interview031902();
        interview.dfs(nums, new ArrayList<>(), isUsed);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public void dfs(int[] nums, List<Integer> list, boolean[] isUsed){
        if (list.size() >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            list.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, list, isUsed);
            list.remove(Integer.valueOf(nums[i]));
            isUsed[i] = false;
        }
    }
}
