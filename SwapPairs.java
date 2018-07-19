/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *  示例:
 *  给定 1->2->3->4, 你应该返回 2->1->4->3.
 *  说明:
 *  你的算法只能使用常数的额外空间。
 */

// 二叉树节点
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 非法输入或只有一个节点
        if (head==null || head.next==null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null && cur.next!=null) {
            int tmp = cur.val;
            cur.val = next.val;
            next.val = tmp;

            if(next.next == null) {
                break;
            }
            cur = next.next;
            if(cur.next == null) {
                break;
            }
            next = cur.next;
        }
        return head;
    }
}
