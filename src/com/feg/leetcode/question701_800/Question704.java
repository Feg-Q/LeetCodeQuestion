package leetcode.question701_800;

/**
 * @author Feg
 * @version 1.0
 * 力扣第704题，二分查找，测试无误。
 */
public class Question704 {
    public static void main(String[] args) {
        Question704 question704 = new Question704();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(question704.search(nums,2));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        return binarySearch(left,right,nums,target);
    }
    public int binarySearch(int left,int right,int[] nums,int target){
        if (right<left){
            return -1;
        }
        int mid = (left+right)/2;
        if (target == nums[mid]){
            return mid;
        }else if (target<nums[mid]){
            return binarySearch(left,mid-1,nums,target);
        }else{
            return binarySearch(mid+1,right,nums,target);
        }
    }
}
