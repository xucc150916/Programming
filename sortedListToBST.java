// 给定一个按升序排序的单链列表，将其转换为高度平衡的BST。

// 顺序表节点定义
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x; next = null;
    }
}

// 树结点定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class SortedListToBST {
    // 快慢指针查询到链表中间节点，以中间节点为根节点，然后递归此过程
    public TreeNode sortedListToBST(ListNode head) {

        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {

        TreeNode root = null;
        // 递归到叶子节点的下一次递归
        if(head == tail) {
            return root;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=tail && fast.next!=tail) {
            // fast一次走两步，slow一次走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        // 创建根节点
        root = new TreeNode(slow.val);
        // 递归
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return  root;
    }
}