package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        // 如果最后一个元素都比目标值小，那么所有元素都小
        if (nums[length-1] < target){
            return length;
        }
        // 双指针
        int left = 0;
        int right = length - 1;

        while (left < right){
            // 中间点,这样计算防止right+left溢出
            int mid = left + (right - left)/2;
            // 如果当前值比目标值小，那意味着目标值在后半部分，因此要移动左指针，取值区间为左闭右闭
            if (nums[mid] < target){
                left = mid + 1;
            } else { // 否则意味着目标值不在右半部分，可能在左半部分或者当前值
                right = mid;
            }
        }
        return left;
    }
}
