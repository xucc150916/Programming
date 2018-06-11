// 链表定义
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 给定一个链表，从列表的末尾删除第n个节点并返回它的头部
public class RemoveNthNodeFromListEnd {
    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        System.out.println(removeNthFromEnd(list, 1).val);
    }

    /**
     * 1. 使用快慢指针查找倒数第n个节点
     * 2. 将倒数第n个节点与倒数第n个节点交换内容并改变倒数第n个节点next指向，删除倒数第n+1个节点
     * @param head 链表头结点
     * @param n 倒数第n个节点
     * @return 删除节点之后的链表头结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 方法一，定义一个变量指向要删除节点之前的节点
//        ListNode slow = head;
//        ListNode fast = head;
//
//        for(int i = 1; i < n; i++) {
//            fast = fast.next;
//        }
//        ListNode prev = null;
//        while (fast.next != null) {
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next;
//        }
//
//        if(prev != null) {
//            prev.next = slow.next;
//        } else {
//            return head.next;
//        }
//        return head;


        // 方法二
        if(head==null || n < 0) {
            return null;
        }
        if(n == 0) {
            return head;
        }

        // 1.
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i < n; i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode tmp = head;
        // 2.
        if(slow.next == null) {// 删除最后一个节点

            while(tmp.next != slow) {
                // 只有一个节点，删除倒数第一个节点
                if(tmp == slow) {
                    return null;
                }
                tmp = tmp.next;
            }
            tmp.next = null;
        } else if(slow == head) {// 删除头节点
            return head.next;
        } else {
            tmp = slow.next;
            slow.val = tmp.val;
            slow.next = tmp.next;
            tmp.next = null;
        }
        return head;
    }
}