package leetcode.question1_100;

/**
 * @author Feg
 * @version 1.0
 * 经典的接雨水问题
 * 自己想的思路是
 * 看了题解，思路核心是分别计算每一个数所对应的柱子的盛水量，然后累加
 * 而计算一个柱子的盛水量只需要算出它左边最长的柱子和右边最长的柱子，然后取较小的减去自身的长度。
 * 理论上来说需要一个for循环遍历每一个柱子计算累加，对每一个柱子都计算它的左右最大值，问题是计算复杂度很高。
 *
 * 优化可以用两个数组分别记录当前柱子左右最大的值，这样就只算了一次。
 *
 * 在优化更好的就是左右指针，对于一个柱子，我们只需要关注左右中最大的值的那个较小的，而不需要关心另一个的值是不是其方向的最大值，
 * 这样以左右两个指针为要计算的柱子，分别计算左指针的左边和右指针的右边的最大值，哪边较小就计算哪边的指针所指的柱子，
 * 然后指针移动一格，另一个指针不动，这样从两边往中间逼近，最终累加得出结果
 */
public class Question42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax<rightMax){
                sum += leftMax - height[left];
                left++;
            }else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
