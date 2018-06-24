
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

// 二叉树节点定义
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
        {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;

        if (diff > 1 || diff < -1)
        {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    int TreeDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }
}
