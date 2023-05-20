package leetcode.question501_600;

import java.util.Stack;

/**
 * @author Feg
 * @version 1.0
 */
public class Question503 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        // 结果数组
        int[] result = new int[length];
        // 模拟单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = length * 2 - 1; i >= 0 ; i--) {
            // 注意第二个条件必须小于等于，因为两个相等得数都是最大的话，左边的那个也应该对应-1，即这时候栈应该是空的。
            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }
            result[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        return result;
    }
}
