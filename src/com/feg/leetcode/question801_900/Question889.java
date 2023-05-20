package com.feg.leetcode.question801_900;

import com.feg.TreeNode;

import java.util.HashMap;

/**
 * 根据前序遍历和后序遍历的结果构建二叉树
 * @author Feg
 * @version 1.0
 * 构造思路
 */
public class Question889 {
    //创建一个map，缓存中序遍历的每一个结果与下标的映射
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //缓存后序遍历的结果和下标的映射
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i],i);
        }
        //调用递归，返回结果
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] preorder,int preStart, int preEnd, int[] postorder,int postStart, int postEnd){
        //这里用前序的preStart和preEnd判断 和 用后续的两个边界判断都是可以的
        if (postStart > postEnd){
            return null;
        }
        //这个判断主要是为了保证下面取 preStart+1 的值的时候不会数组越界，即保证子树长度至少为2再进行下面的
        if (preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        //前序遍历的第一个值或者后序遍历的最后一个值就是根节点的值
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //前序遍历的第二个值就是左子树的根节点的值
        int leftVal = preorder[preStart + 1];
        //从后序遍历的结果中找出这个左子树的根节点的值
        int leftIndex = map.get(leftVal);
        //size表示左子树的长度
        int size = leftIndex - postStart + 1;
        //注意传入的边界值
        root.left = build(preorder,preStart + 1,preStart + size,postorder,postStart,leftIndex);
        root.right = build(preorder,preStart + size + 1,preEnd,postorder,leftIndex + 1,postEnd -1);
        return root;
    }
}
