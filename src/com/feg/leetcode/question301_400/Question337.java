package leetcode.question301_400;

import com.feg.TreeNode;
import java.util.HashMap;

/**
 * 打家劫舍问题III，不过是在二叉树上
 * @author Feg
 * @version 1.0
 */
public class Question337 {
    HashMap<TreeNode,Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 从map中看有没有计算过了，如果有，直接返回
        if (dp.containsKey(root)){
            return dp.get(root);
        }
        // 当前结点的收益，分为两种，抢当前、不抢当前；
        //如果抢当前
        int profitYes = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //如果不抢当前
        int profitNO = (root.left == null ? 0 : rob(root.left)) + (root.right == null ? 0 : rob(root.right));
        // 比较两者的最大值，并存入map
        int profit = Math.max(profitYes,profitNO);
        dp.put(root,profit);
        return profit;
    }
}
