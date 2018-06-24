/**
 * 返回后序遍历结果
 */

import javafx.scene.chart.StackedAreaChart;

import java.util.ArrayList;
import java.util.Stack;


// 方法一：递归后序遍历
// 方法二：迭代


// 二叉树节点定义
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PostOrder {
    // 方法一
//    public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if(root == null) {
//            return list;
//        }
//        postOrder(root, list);
//        return list;
//    }
//
//    public void postOrder(TreeNode root, ArrayList<Integer> list) {
//        if(root.val == '#') {
//            return;
//        }
//        postOrder(root.left, list);
//        postOrder(root.right, list);
//        list.add(root.val);
//    }

    // 方法二：迭代实现
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
            list.add(0, cur.val);
        }
        return list;
    }

}
