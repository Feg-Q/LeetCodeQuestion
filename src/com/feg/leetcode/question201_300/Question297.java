package leetcode.question201_300;

import com.feg.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的序列化和反序列化
 * @author Feg
 * @version 1.0
 */
public class Question297 {
    public static void main(String[] args) {
        String s = "1,2,#,#,3,4,#,#,5,#,#,";
        Question297 question297 = new Question297();
        System.out.println(question297.serialize2(question297.deserialize2(s)));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuffer = new StringBuilder();
        dfsSer(root,stringBuffer);
        return stringBuffer.toString();
    }
    public void dfsSer(TreeNode root,StringBuilder stringBuilder){
        if (root == null){
            stringBuilder.append("#,");
            return;
        }
        stringBuilder.append(root.val + ",");
        dfsSer(root.left,stringBuilder);
        dfsSer(root.right,stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] strings = data.split(",");
        for (String string : strings) {
            list.addLast(string);
        }
        return dfsDes(list);
    }
    //这个递归函数妙啊，用一个list保存，
    // 然后左递归的时候就会逐渐的删除每一个左子树的元素，等到要右递归的时候，正好删完了左子树的所有元素，剩下的都是右子树的
    public TreeNode dfsDes(LinkedList<String> list){
        //list为空，代表已经走到最后，直接返回null
        if (list.isEmpty()){
            return null;
        }
        String s = list.removeFirst();
        //当前第一位是"#"，代表这个结点是null
        if ("#".equals(s)){
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = dfsDes(list);
        root.right = dfsDes(list);
        return root;
    }

    //下面是后序遍历的方式
    public String serialize2(TreeNode root) {
        StringBuilder stringBuffer = new StringBuilder();
        dfsSer(root,stringBuffer);
        return stringBuffer.toString();
    }
    public void dfsSer2(TreeNode root,StringBuilder stringBuilder){
        if (root == null){
            stringBuilder.append("#,");
            return;
        }
        dfsSer(root.left,stringBuilder);
        dfsSer(root.right,stringBuilder);
        stringBuilder.append(root.val + ",");
    }
    public TreeNode deserialize2(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] strings = data.split(",");
        for (String string : strings) {
            list.addLast(string);
        }
        return dfsDes(list);
    }
    public TreeNode dfsDes2(LinkedList<String> list){
        //list为空，代表已经走到最后，直接返回null
        if (list.isEmpty()){
            return null;
        }
        //后序遍历的最后一个值是当前根结点的值
        String s = list.removeLast();
        //当前最后一位是"#"，代表这个结点是null
        if ("#".equals(s)){
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.right = dfsDes(list);
        root.left = dfsDes(list);
        return root;
    }
}
