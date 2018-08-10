/**
 * 给一个二叉树，将其变为它的镜像
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Mirror {

    public void Mirror(TreeNode root) {
        // 非法输入
        if (root == null) {
            return;
        }

        // 递归调换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }

}
