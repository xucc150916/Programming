import java.util.*;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 递归与迭代
 */
public class PerorderBinaryTree {

    /*******************  递归算法  ***********************/
//    private List<Integer> list = new ArrayList<>();;
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return list;
//        }
//
//        preorderTraversalCore(root);
//        return list;
//    }
//    private void preorderTraversalCore(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        preorderTraversalCore(root.left);
//        preorderTraversalCore(root.right);
//    }
    /*******************  迭代算法  ***********************/
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // 使用一个辅助栈
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            list.add(cur.val);
            stack.pop();
            if (cur.right != null) {
                stack.push(cur.left);
            }
            if (cur.left != null) {
                stack.push(cur.right);
            }

        }
        return list;
    }


}
