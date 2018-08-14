import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 解题思路：
 * 1. 如果当前节点存在右子树，那么下一个节点就是右子树最左孩子
 * 2. 如果当前节点没有右子树，一直向上，如果节点的是父节点的左子树(node.next.left == node)，下一个节点就是父节点，一直退到根节点，那就是根节点了(画图)
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 非法输入
        if (pNode == null) {
            return pNode;
        }

        TreeLinkNode cur = pNode;
        // 1.
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        // 2.
        while (cur.next != null) {
            if (cur.next.left == cur) {
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }
}