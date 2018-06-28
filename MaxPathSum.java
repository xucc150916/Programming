/**
 * 给定一个二叉树，找到最大路径和，路径可以在树中的任何节点开始和结束
 * 即求出二叉树中各节点加起来和最大的一段路径
 */


// 二叉树节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaxPathSum {
    public int maxValue;

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        maxValue = Integer.MIN_VALUE;
        maxPath(root);
        return maxValue;
    }

    // 递归
    public int maxPath(TreeNode root) {
        // 左子树中路径和最大的值
        int leftValue;
        // 右子树中路径和最大的值
        int rightValue;

        if(root.left == null) {
            leftValue = 0;
        } else {
            // 与0比较，防止该段路径值为负数
            leftValue = max(0, maxPath(root.left));
        }
        if(root.right == null) {
            rightValue = 0;
        } else {
            rightValue = max(0, maxPath(root.right));
        }

        // 更新maxValue值
        maxValue = max(maxValue, leftValue+rightValue+root.val);
        // 返回以当前节点为头的路径最大和
        return root.val+max(leftValue, rightValue);
    }

    public int max(int num1, int num2) {
        return num1>num2 ? num1 : num2;
    }
}
