/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 解题思路：BST中序遍历结果为从小到大的数列，那么位置错乱必定第一个错误的数字为大，所以它后一个数比它小，而第二个数，比前一个数小
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RecoverTree {

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode biggerNode = null;
    TreeNode smallerNode = null;

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = biggerNode.val;
        biggerNode.val = smallerNode.val;
        smallerNode.val = tmp;
    }

    // 中序遍历的结果是一个递增的数列
    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 找到第一个比前一个数小的数，它的前一个就是位置错误的元素，记录前一个数
        inorderTraverse(root.left);
        if (biggerNode == null && root.val <= preNode.val) {
            biggerNode = preNode;
        }
        // 找到第一个错误的数字之后，另一个是比前一个数小的数
        if (biggerNode != null && root.val <= preNode.val) {
            smallerNode = root;
        }
        preNode = root;
        inorderTraverse(root.right);
    }

}
