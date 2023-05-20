package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 */
public class Question34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = 0;
        int right = nums.length;
        if (right == 0){
            return result;
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid;
                result[0] = right;
            }else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid;
            }
        }
        left = 0;
        right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
                result[1] = left - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid;
            }
        }
        return result;
    }
}
