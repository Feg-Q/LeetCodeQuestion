package leetcode.question601_700;

import com.feg.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找一颗二叉树的重复子树
 * 这道题正好用到序列化的知识，如何判断一个子树在整个二叉树中是否有重复的部分，需要两步：
 * 第一，需要知道自身是什么样子的，第二，从其它已经遍历过的子树比较是否有重复。
 * 那么怎么比较两课树？可以将树按照同一规则序列化，这样就方便判断了。
 * @author Feg
 * @version 1.0
 */
public class Question652 {

    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return result;
    }
    public String find(TreeNode root){
        if (root == null){
            // 空节点用 # 表示
            return "#";
        }
        String left = find(root.left);
        String right = find(root.right);
        // 拼接当前结点以及其左右子树,注意用后序遍历的方式
        String ser = left + "," + right + "," + root.val;
        // 从map中寻找这个树的出现次数
        int count = map.getOrDefault(ser, 0);
        if (count == 1){ // 说明在这个结点以前有重复的
            // 此处仅当以前出现过一次判断当前结点有重复，因为之后如果再有重复也仅需加入这一次
            result.add(root);
        }
        // 不管有没有重复，都要把当前结点加入到map中
        map.put(ser,count + 1);
        return ser;
    }
}
