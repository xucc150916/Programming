/**
 * 给定一棵二叉树，返回它的预序遍历
 * 节点的值。
 */

import java.util.ArrayList;
import java.util.Stack;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    // 方法一：递归先序遍历
//    public ArrayList<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if(root == null) {
//            return list;
//        }
//        preCore(root, list);
//        return list;
//    }
//
//    public void preCore(TreeNode root, ArrayList<Integer> list) {
//        if('#' == root.val) {
//            return;
//        }
//        list.add(root.val);
//        preCore(root.left, list);
//        preCore(root.right, list);
//    }

    // 方法二：迭代遍历
    public ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur!=null || !stack.empty()) {
            if(cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }

}
