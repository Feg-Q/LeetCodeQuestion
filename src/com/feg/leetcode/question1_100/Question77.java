package leetcode.question1_100;

import java.util.*;

/**
 * @author Feg
 * @version 1.0
 * 回溯算法
 */
public class Question77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = new Question77().combine(6, 2);
        System.out.println(combine);
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        dfs2(n,1,stack,k);
        return result;
    }

    public void dfs(List<Integer> list,int start,List<Integer> temp,int k){
        //结束递归的条件：临时数组中已经加入了k个数
        if (temp.size() >= k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            // 递归前，取出一个数据，保存在路径中
            Integer integer = list.get(i);
            if (integer != null && integer > 0){
                temp.add(integer);
                list.remove(integer);
            }
            dfs(list,i,temp,k);
            // 递归后，将取出的数据放回去，并保持原来的顺序
            list.add(integer);
            list.sort(Comparator.comparingInt(m -> m));
            temp.remove(integer);
        }
    }

    public void dfs2(int n, int start, Stack<Integer> stack, int k){
        //结束递归的条件：临时数组中已经加入了k个数
        if (stack.size() >= k){
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 递归前，取出一个数据，保存在路径中
            stack.add(i);
            dfs2(n,i + 1,stack,k);
            // 递归后，将取出的数据放回去，并保持原来的顺序
            stack.pop();
        }
    }
}
