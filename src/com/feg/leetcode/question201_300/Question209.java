package leetcode.question201_300;

/**
 * @author Feg
 * @version 1.0
 */
public class Question209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 左右指针
        int left = 0;
        int right = 0;
        // 结果值，先取最大值
        int res = Integer.MAX_VALUE;
        // 区间和
        int sum = 0;
        while (right < nums.length){
            // 如果和比目标值小，那就继续移动右指针
            if (sum < target){
                right++;
                // 移动右指针后要判断越界，如果越界了，直接退出循环
                if(right == nums.length){
                    break;
                }
                // 没有越界，那就和加上当前右指针的值
                sum += nums[right];
            }else {
                // 和不小于目标值的情况，更新结果值，然后移动左指针，注意同步更新区间和
                res = Math.min(res,right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
