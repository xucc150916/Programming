import java.util.ArrayList;

/**
 * 恢复二叉搜索树。二叉搜索树的两个元素被错误地交换了。在不改变结构的情况下恢复树
 */

// 二叉树节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RecoverTree {

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        // 将二叉树中序遍历结果按顺序拷贝到list中
        // BST中序遍历结果是从小到大依次排列的一组数
        treeCopy(root, list);

        // 记录放错位置的两个节点。因为这两个节点不一定是相邻的，所以接下来寻找的过程要用两个for循环从头到尾，从尾到头分两次俩寻找。
        TreeNode firstPoint = null;
        TreeNode secondPoint = null;

        // 寻找出问题的两个节点
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i).val > list.get(i+1).val) {
                firstPoint = list.get(i);
                // 找到第一组之后就要退出当前循环，否则会误判
                break;
            }
        }
        for(int i = list.size()-1; i > 0; i--) {
            if(list.get(i).val < list.get(i-1).val) {
                secondPoint = list.get(i);
                // 同上
                break;
            }
        }

        // 交换两个节点的值就可以了
        int tmp = firstPoint.val;
        firstPoint.val = secondPoint.val;
        secondPoint.val = tmp;
    }

    public void treeCopy(TreeNode root, ArrayList<TreeNode> list) {
        if(root==null || list==null) {
            return;
        }
        treeCopy(root.left, list);
        list.add(root);
        treeCopy(root.right, list);
    }
}
