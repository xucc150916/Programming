/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 方法一：求出链表长度k，实际旋转长度为n%=k，从该位置断开(该点next=null)，记录后半段为新的头结点，将其最后指向前半段head
 * 方法二：一个指针，先遍历整个链表获得链表长度n，然后此时把链表头和尾链接起来，再往后走n - k % n个节点就到达新链表的头结点前一个点，这时断开链表即可。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RotateList {

    public ListNode rotateRight1(ListNode head, int k) {
        // 非法输入
        if (head == null || k == 0) {
            return head;
        }

        ListNode fast = head;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        // 实际要旋转的长度
        k %= len;

        ListNode slow = head;
        fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // fast.next指向头结点
        fast.next = head;
        // fast指向新节点的头结点
        fast = slow.next;
        // 断开两个链表
        slow.next = null;
        return fast;
    }


    public ListNode rotateRight2(ListNode head, int k) {
        // 非法输入
        if (head == null || k == 0) {
            return head;
        }

        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        cur.next = head;
        int step = len - k % len;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;

    }
}
