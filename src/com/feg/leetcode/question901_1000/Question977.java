package leetcode.question901_1000;

/**
 * @author Feg
 * @version 1.0
 * 考虑四种情况，还算简单，就是代码比较多
 * 卧槽，还有这么简单的算法
 */
public class Question977 {
    public static void main(String[] args) {
        int[] input = new int[]{-9,-3,-1,2,5,6};
        new Question977().sortedSquares2(input);
    }
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left;
        int right;
        int[] result = new int[length];
        if(nums[0]>=0){
            right=0;
            left=-1;
        }else{
            left = 0;
            right = 1;
        }
        while(right<length && nums[right]<=0){
            right++;
            left++;
        }
        if(left==-1){//全正数的情况
            for(int i=0;i<length;i++){
                result[i] = nums[i]*nums[i];
            }
        }else if(right==length){//全负数的情况
            for(int i=0,j=length-1;i<length;i++,j--){
                result[i] = nums[j]*nums[j];
            }
        }else{
            int i = 0;
            while(left>=0&&right<length){
                int leftValue = nums[left]*nums[left];
                int rightValue = nums[right]*nums[right];
                if(leftValue>rightValue){
                    result[i] = rightValue;
                    right++;
                }else{
                    result[i] = leftValue;
                    left--;
                }
                i++;
            }
            if(left<0&&right<length){
                while(right<length){
                    result[i] = nums[right]*nums[right];
                    i++;
                    right++;
                }
            }else if(right>=length&&left>=0){
                while(left>=0){
                    result[i] = nums[left]*nums[left];
                    i++;
                    left--;
                }
            }
        }
        return result;
    }

    /**
     * 双指针的解法
     */
    public int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        int i = 0;
        int j = k;
        while (i < j){
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a > b) {
                result[k] = a;
                i++;
            } else {
                result[k] = b;
                j--;
            }
            k--;
        }
        result[0] = nums[i] * nums[i];
        return result;
    }
}
