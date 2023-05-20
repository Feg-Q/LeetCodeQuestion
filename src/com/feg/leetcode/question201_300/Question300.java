package leetcode.question201_300;

/**
 * @author Feg
 * @version 1.0
 * 还是看了题解了，本来已经定义好了dp数组，但递推公式推不出来，因为如果当前元素小于前一个元素的话，那怎么判断前面还有没有符合要求的元素
 * 我没想到是直接遍历，这样时间复杂度就高了。
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        // 定义dp数组，第i项表示以第i个数组为结尾的最长递增子序列的长度
        //这里不能直接定义dp是前i项中最长递增子序列的长度，因为无法确定这个子序列的最后一个值是多少，也就无法比较当前值
        int[] dp = new int[length];
        // 只有第一个元素的时候自然是1
        dp[0] = 1;
        // 遍历这个数组每一个元素，从i=1开始
        for (int i = 1; i < length; i++) {
            int maxLength = 0;
            // 当前这个元素值可能小于前一个值，但只要前面有比这个元素小的值，那么把这个值挂到较小的子序列上就还是一个递增子序列
            //而前面可能有不止一个较小的子序列，我们就全部比较其最长递增子序列的长度，找到最长的
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    maxLength = Math.max(maxLength,dp[j]);
                }
            }
            //那么以当前元素为结尾的最长递增子序列的长度就是前面找到的最长的值加上1
            dp[i] = maxLength + 1;
        }
        // 从每一个以当前元素为结尾的最长递增子序列的长度中找出最长的就是最终答案
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
