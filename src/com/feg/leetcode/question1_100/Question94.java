package leetcode.question1_100;

import com.feg.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * 简简单单的一个中序遍历的递归算法
 * 可以再考虑迭代
 */
public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root!=null) {
            dfs(list, root);
        }
        return list;
    }
    void dfs(List<Integer> list,TreeNode node){
        if (node.left!=null){
            dfs(list,node.left);
        }
        list.add(node.val);
        if (node.right!=null){
            dfs(list,node.right);
        }
    }
}
