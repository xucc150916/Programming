import java.util.ArrayList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 解题思路：BST中序遍历递增，保存其中序遍历结果，然后遍历该结果如果比前一个小，返回false
 */
public class IsValidBST {

    /**
     * 时间复杂度为O(n)，空间复杂度为O(1)
     */
    private boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return flag;
    }

    private void isValidBST(TreeNode root, int high, int low) {
        if (root == null) {
            return;
        }
        if (root.val <= low || root.val >= high) {
            flag = false;
            return;
        }
        isValidBST(root.left, low, root.val);
        isValidBST(root.right, root.val, high);
    }


        /**
         * 时间复杂度O(n)，空间复杂度O(n)
         */
//    ArrayList<Integer> list = new ArrayList<>();
//
//    public boolean isValidBST(TreeNode root) {
//        inorder(root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) > list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void inorder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left);
//        list.add(root.val);
//        inorder(root.right);
//    }


    }
