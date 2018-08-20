import java.util.ArrayList;

/**
 * 给定n，生成所有包含1-n不同结构的的二叉搜索树，返回的集合中每个元素都是一个BST的头结点
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class GenerateTrees {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateCore(1, n);
    }

    // 递归创建
    public ArrayList<TreeNode> generateCore(int low, int hight) {
        ArrayList<TreeNode> ret = new ArrayList<>();

        if(low > hight) {
            ret.add(null);
            return ret;
        }

        /**
         * 1. 依次将low-hight分成两个不同的部分，递归操作(这同时也能满足BST的要求，因为low-hight是递增的)
         * 2. 将这两个部分每个元素与其他所有元素依次组合拼接
         */
        for(int i = low; i <= hight; i++) {
            // 1.
            ArrayList<TreeNode> leftTree = generateCore(low, i-1);
            ArrayList<TreeNode> rightTree = generateCore(i+1, hight);
            // 2.
            for(int j = 0; j < leftTree.size(); j++) {
                for(int k = 0; k < rightTree.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree.get(j);
                    node.right = rightTree.get(k);
                    ret.add(node);
                }
            }
        }
        return ret;
    }
}
