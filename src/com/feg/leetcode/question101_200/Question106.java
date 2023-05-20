package leetcode.question101_200;

import com.feg.TreeNode;

import java.util.HashMap;

/**
 * 根据中序和后序遍历的结果构建二叉树
 * @author Feg
 * @version 1.0
 * 注意边界值
 */
public class Question106 {
    //创建一个map，缓存中序遍历的每一个结果与下标的映射
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder,int postStart, int postEnd){
        //这里以中序遍历传入的开始和结束结点作为判断子树为空的条件，因为对于后序遍历，postStart+size-1 要大于postStart
        if (postStart > postEnd){
            return null;
        }
        //后序遍历的最后一个值就是根节点的值
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int size = rootIndex - inStart;
        //这里传入的最后一个参数是postStart+size-1，因为长度为1代表只有自己，那对于左闭右闭的区间其边界就还是start，下面right同理
        root.left = build(inorder,inStart,rootIndex - 1,postorder,postStart,postStart + size - 1);
        root.right = build(inorder,rootIndex + 1,inEnd,postorder,postStart + size,postEnd -1);
        return root;
    }
}
