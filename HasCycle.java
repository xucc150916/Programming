/**
 * 给定一个链表，判断链表中是否有环。
 * 进阶：
 * 你能否不使用额外空间解决此题？
 * <p>
 * 普通解法：快慢指针，两指针相遇，则成环，如果为空，无环
 * 进阶解法：每个元素自己成环，如果当前元素的next指向当前元素，证明该元素经历过，则成环
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode cur = head.next;
        // 自成环
        head.next = head;
        return hasCycle(cur);
    }
}
