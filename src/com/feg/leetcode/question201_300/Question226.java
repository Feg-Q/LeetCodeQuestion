package leetcode.question201_300;

import com.feg.TreeNode;

/**
 * 翻转二叉树
 * @author Feg
 * @version 1.0
 */
public class Question226 {
    // 下面是遍历的思路
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 下面是分解问题的思路
    public TreeNode invertTree2(TreeNode root) {
        turnOver(root);
        return root;
    }
    public TreeNode turnOver(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = turnOver(root.left);
        TreeNode right = turnOver(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
