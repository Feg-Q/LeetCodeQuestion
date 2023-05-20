package leetcode.question601_700;

import com.feg.TreeNode;

/**
 * 构造最大二叉树
 * @author Feg
 * @version 1.0
 */
public class Question654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int[] nums,int left,int right){
        //left和right是左闭右闭的区间
        if (left > right){
            return null;
        }
        //先找到nums数组的最大值,及其下标
        int maxNum = -1;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i]>maxNum){
                maxNum = nums[i];
                index = i;
            }
        }
        //根据这个最大值构造根节点
        TreeNode root = new TreeNode(maxNum);
        // 构造根节点的左子节点
        root.left = construct(nums,left,index-1);
        // 构造根节点的右子节点
        root.right = construct(nums,index+1,right);
        // 返回当前根节点
        return root;
    }
}
