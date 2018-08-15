/**
 * 二叉树的序列化与反序列化
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Serialize {
        /**
         * 二叉树序列化，空节点用"#"表示
         */
        String Serialize(TreeNode root) {
            if (root == null) {
                return "#,";
            }
            StringBuilder sb = new StringBuilder("");
            sb.append(root.val).append(",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }

        /**
         * 反序列化，遇到"#"返回null
         */
        int index = -1;
        TreeNode Deserialize(String str) {
            index++;
            if (str.length() < index) {
                return null;
            }
            String[] data = str.split(",");
            TreeNode node = null;
            if (!data[index].equals("#")) {
                node = new TreeNode(Integer.parseInt(data[index]));
                node.left = Deserialize(str);
                node.right = Deserialize(str);
            }
            return node;
        }
}
