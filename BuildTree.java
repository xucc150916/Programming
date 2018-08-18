/**
 * 通过二叉树中序遍历与后续遍历重建二叉树
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

}

public class buildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                node.left = buildTree(inorder, inStart, i - 1,
                        postorder, postStart, postStart - inStart + i - 1);

                node.right = buildTree(inorder, i + 1, inEnd,
                        postorder, postEnd - inEnd + i, postEnd - 1);
            }
        }
        return node;

    }

    private TreeNode buildTree2(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postEnd);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                node.left = buildTree2(inorder, inStart, i - 1,
                        postorder, postStart, postStart + i - 1 - inStart);
                node.right = buildTree2(inorder, i+1, inEnd,
                        postorder, postEnd-inEnd+i, postEnd-1);
                break;
            }
        }
        return node;
    }


}
