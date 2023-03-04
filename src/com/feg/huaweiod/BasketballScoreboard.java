package com.feg.huaweiod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Feg
 * @version 1.0
 */
public class BasketballScoreboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        // 得分数组
        int[] nums = new int[count];
        // 数组的总和
        int sum = 0;
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 对每一个可能的平分数做判断
        for (int i = count; i > 0 ; i--) {
            // 不够平分不满足要求
            if (sum % i != 0){
                continue;
            }
            // 最大的值比一份的大小大则不符合要求
            if (nums[count-1] > sum / i){
                continue;
            }
            if (dp(nums,0,sum/i,0,i,new boolean[count])){
                System.out.println(sum/i);
                break;
            }
        }
    }

    /**
     *
     * @param nums 存储数据的数组
     * @param per 目标值
     * @param k 还剩几个桶没满
     * @param vi 是否已经用过数组
     * @return
     */
    public static boolean dp(int[] nums,int start,int per,int curSum,int k,boolean[] vi){
        // 5.1.4.2.3.3
        // 所有桶都装满了，返回true
        if (k == 0){
            return true;
        }
        // 这个桶装满了，开始下一个桶，从第0个数字开始
        if (curSum == per) {
            return dp(nums,0,per,0,k-1,vi);
        }
        // 往后遍历数字
        for (int i = start; i < nums.length; i++) {
            // 如果当前数字已经使用过了，就继续下一个
            if (vi[i]){
                continue;
            }
            // 数字太大了，装不进去
            if (nums[i] + curSum > per){
                return false;
            }
            // 做选择
            vi[i] = true;
            // 判断下一个数字
            if (dp(nums,i + 1,per,curSum+nums[i],k,vi)){
                return true;
            };
            // 撤销选择
            vi[i] = false;
            // curSum = curSum - nums[i];
        }
        return false;
    }
}
