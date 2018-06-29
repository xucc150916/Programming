import java.util.ArrayList;

/**
 * 给定一棵二叉树，确定它是否是有效的二叉搜索树
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 利用二叉搜索树中序遍历结果从小到大进行判断
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        treeCopy(root, list);
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void treeCopy(TreeNode root, ArrayList<Integer> list) {
        if(root==null || list==null) {
            return;
        }
        treeCopy(root.left, list);
        list.add(root.val);
        treeCopy(root.right, list);
    }
}
