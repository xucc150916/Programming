import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树递归迭代
 */

public class InorderTraversal {
    // 中序递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        inorderTraversal(root, list);
//        return list;
//    }
//
//    private void inorderTraversal(TreeNode node, List<Integer> list) {
//        if (node == null) {
//            return;
//        }
//        inorderTraversal(node.left, list);
//        list.add(node.val);
//        inorderTraversal(node.right, list);
//    }


	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 辅助栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
