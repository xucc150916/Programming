/**
 * 输入一颗二叉搜索树，将其转换为一个排序的双向链表，不允许创建任何新的节点
 *
 * 解题思路：
 *      left为双链表的pre，right为双链表的next，与树相关的操作用递归
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Convert {

    public TreeNode preNode = null;

    public TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }

        convert(pRootOfTree);
        return realHead;
    }

    public void convert(TreeNode node) {
        if (node == null) {
            return;
        }

        convert(node.left);
        if (realHead == null) {
            realHead = node;
            preNode = node;
        } else {
            node.left = preNode;
            preNode.right = node;
            preNode = node;
        }
        convert(node.right);
    }
}
