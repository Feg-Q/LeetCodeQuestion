package com.feg.leetcode.question401_500;

/**
 * 目标和
 * @author Feg
 * @version 1.0
 * 回溯或者动态规划
 * 这题卡了我三次，第一次提交用的回溯，时间复杂度太高；
 * 第二次改成动态规划，结果卡了[1,0]这个输入，因为我初始化的语句有条件没进去，而且我循环是从第2行第1列开始的，也没进去
 * 第三次还是卡了上面的原因，所以把第一行的初始化去了，然后循环从第一行开始，
 * 结果卡在了一个没考虑到的地方，即数组和加上target应该是偶数这个条件，确实没考虑到，改了限制之后就过了。
 */
public class Question494 {
    int res;
    // 回溯算法，复杂度2的n次方
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        dfs(nums,0,0,target);
        return res;
    }
    public void dfs(int[] nums,int n,int sum,int target){
        // 到达叶子结点，进行判断
        if (n == nums.length ){
            // 如果此时符合了target，则给res加一
            if ( sum == target) {
                res++;
            }
            return;
        }
        // 做选择，假设是+号
        sum = sum + nums[n];
        // 往下一层递归
        dfs(nums,n+1,sum,target);
        // 撤销刚才的选择
        sum = sum - nums[n];
        // 另一个选择
        sum = sum - nums[n];
        // 下一层
        dfs(nums,n+1,sum,target);
        // 撤销选择
        sum = sum + nums[n];
    }
    // 动态规划
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target > sum){
            return 0;
        }
        // 为什么有这个限制？
        //理解了，假设有a，b，c，d.....z个元素，这些元素可能有加有减最后算出来target，而sum是全加起来，
        //因此这两个式子相加的话，就会抵消所有减号的元素，只剩下加号的元素加了两次，则必然是偶数，
        //也就是说想要凑出来这个target，必须满足最后偶数的条件。
        if ((target + sum) % 2 != 0){
            return 0;
        }
        int nag = (sum - target) / 2;
        int length = nums.length;
        int[][] dpTable = new int[length + 1][nag+1];
        for(int i = 0;i<=length;i++){
            dpTable[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= nag; j++) {
                if (j < nums[i-1]){
                    dpTable[i][j] = dpTable[i-1][j];
                } else {
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i-1][j-nums[i-1]];
                }
            }
        }
        return dpTable[length][nag];
    }
}
