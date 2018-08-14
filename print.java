import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

// 二叉树定义
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

// 使用队列层序遍历二叉树
public class Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) {
            return list;
        }

        TreeNode cur = pRoot;
        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将头结点入队列
        queue.add(cur);
        while (!queue.isEmpty()) {
            // row存储每一行的数据
            ArrayList<Integer> row = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                // 打印当前栈顶元素
                System.out.println(queue.peek());
                // 弹出队首
                row.add(queue.poll().val);
            }
            list.add(row);
        }
        return list;
    }
	
	// 递归版本
    void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> lists) {
        if (root == null) {
            return;
        }
        if (depth > lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth-1).add(root.val);
        depth(root.left, depth+1, lists);
        depth(root.right, depth+1, lists);
        return;
    }
	
}
