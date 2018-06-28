/**
 * 给定两棵二叉树，写一个函数来检查它们是否相等。如果两个二叉树在结构上是相同的并且节点具有相同的值，则被认为是相等的
 */

// 二叉树节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        if(p==null || q==null) {
            return false;
        }
        return isSameTreeCore(p, q);
    }

    public boolean isSameTreeCore(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) {
            return true;
        }
        if(root1==null || root2==null) {
            return false;
        }
        if(root1.val == root2.val) {
            return isSameTreeCore(root1.left, root2.left) && isSameTreeCore(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
