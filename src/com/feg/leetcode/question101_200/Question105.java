package leetcode.question101_200;

import com.feg.TreeNode;

import java.util.HashMap;

/**
 * 根据前序遍历和中序遍历构造二叉树
 * @author Feg
 * @version 1.0
 */
public class Question105 {
    public static void main(String[] args) {
        new Question105().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    /**
     *
     * @param preorder 前序遍历的结果数组
     * @param preStart 左子树的起点
     * @param preEnd 左子树的截止下标
     * @param inorder 中序遍历的结果数组
     * @param inStart 右子树的起点
     * @param inEnd 右子树的截止下标
     * @return 根节点
     */
    public TreeNode build(int[] preorder,int preStart, int preEnd, int[] inorder,int inStart,int inEnd){
        if (preStart > preEnd){
            return null;
        }
        // 构造根节点，值是前序遍历的第一个值
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,rootIndex - 1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }
}
