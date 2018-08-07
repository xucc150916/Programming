/**
 * 删除链表倒数第n个节点
 *
 * 解题思路：
 * 偷梁换柱，将下一个节点删除，把它的值和next指向复制到倒数第n个节点上。这里要注意删除头结点尾节点两种极端情况
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        // 1. 删除头结点
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast != null) {
            fast = fast.next;
            // 2. 处理删除最后一个节点的情况
            if (slow.next.next == null) {
                // 就地删除
                slow.next = null;
                return head;
            }
            slow = slow.next;
        }
        // 3. 普通情况
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;

    }
}
