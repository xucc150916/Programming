/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class MinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        System.out.println(new MinDepth().run1(root));
    }

    /**
     * 方法一
     */
    public int run1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = run1(root.left);
        int right = run1(root.right);
        // 左子树为空，就不从左边走了
        if (root.left == null) {
            left = Integer.MAX_VALUE;
        }
        // 右子树为空，不从这走
        if (root.right == null) {
            right = Integer.MAX_VALUE;
        }

        return left > right ? right + 1 : left + 1;
    }

    /**
     * 方法二
     */
    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return run2(root.right) + 1;
        }
        if (root.right == null) {
            return run2(root.left) + 1;
        }


        return 1 + (run2(root.left) > run2(root.right) ?
            run2(root.right) : run2(root.left));

    }


}
