package com.feg.leetcode.question1_100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * 经典回溯算法
 */
public class Question46 {

    List<List<Integer>> result = new LinkedList<>();//需要一个List集合来保存最终结果

    public List<List<Integer>> permute(int[] nums) {
        boolean[] decide = new boolean[nums.length];//需要一个和nums数组等大的Boolean数组来记录nums数组各个元素的使用情况
        LinkedList<Integer> list = new LinkedList<>();//需要一个list集合来保存单次结果
        dfs(nums,decide,list);
        return result;
    }

    void dfs(int[] nums,boolean[] decide,List<Integer> list){
        //这里是递归终止条件,递归到底后将本次保存的单次结果保存到最终结果集合中
        if (list.size()==nums.length){
            result.add(new LinkedList<>(list));
            return;
        }
        //开始循环遍历递归
        for (int i = 0; i < nums.length; i++) {
            //跳过已经经过的路径
            if (decide[i]){
                continue;
            }
            list.add(nums[i]);//将当前数字加入到路径
            decide[i] = true;//将当前数字设置为已经经过
            dfs(nums,decide,list);//递归
            list.remove(new Integer(nums[i]));//递归后将当前元素移除路径，并设置为未经过，便于下一次递归
            decide[i] = false;
        }
    }
}
