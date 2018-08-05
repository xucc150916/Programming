/**
 * 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 思路：
 * 1. 找到链表中点
 * 2. 逆置后半部分节点
 * 3. 将后半部分节点依次插入前半部分节点
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 找到中点
        ListNode fast = head;
        ListNode slow = head;
        // 通过快慢指针得到的中间节点slow，如果节点数为奇数，slow恰好为中间节点，为偶数，slow为中间两个节点之中的前一个
        while (fast!= null && fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 翻转后半部分的链表
        ListNode latterHead = slow.next;
        // 将两个链表断开
        slow.next = null;
        // 指向当前节点
        fast = latterHead;
        // 指向前一个节点
        slow = null;
        while (fast != null) {
            fast = fast.next;
            latterHead.next = slow;
            slow = latterHead;
            latterHead = fast;
        }

        latterHead = slow;
        // 对两个链表开始插
        slow = head;
        fast = latterHead;
        while (fast != null) {
            ListNode tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow = slow.next;
            slow.next = tmp;
            slow = slow.next;
        }

    }

}
