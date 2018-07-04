/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 使用二叉树节点的左右字数指针依次指向前后节点
 * 利用BST中序遍历为从小到大的序列这一特性进行操作
 */

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//}

public class Convert {

    // 前一个节点
    TreeNode preNode = null;
    // 存储BST最小的节点，即即最左侧节点
    TreeNode realHead = null;


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return pRootOfTree;
        }
        convertCore(pRootOfTree);
        return realHead;
    }

    public void convertCore(TreeNode node) {
        if(node == null) {
            return;
        }


        convertCore(node.left);
        // 只有找到最左侧节点时才会进入if，因为一直向左侧递归，直到到达最左侧节点才会执行接下来的语句
        if(realHead == null) {
            preNode = node;
            realHead = node;
        } else {
            // left指向前一个节点，即preNode，realHead在这里进行赋值，双链表的头结点
            node.left = preNode;
            preNode.right = node;
            preNode = node;
        }
        convertCore(node.right);
    }
}
