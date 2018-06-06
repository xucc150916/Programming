package 六月五日;

// 一个链表带环，求这个环的入口点

// 链表节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class EntryNodeOfLoop {

    // 方法一
    // 使用快慢指针，两个一起走，直到相遇点
    // 再定义一个指针从头节点开始，和相遇点的指针一起向前走，两者相遇点就是入口点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 输入空链表
        if(pHead == null) {
            return null;
        }

        ListNode slow = pHead.next;
        // 防止链表只有一个节点
        if(slow == null) {
            return null;
        }
        ListNode fast = slow.next;

        // fast一次走两步，要保证接下来的两步都不为空
        while(fast!=null && fast.next!=null) {
            if(slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // fast != slow 链表不带环，返回null
        if(fast != slow) {
            return null;
        } else {// fast == slow 证明找到了相遇点，带环
            ListNode cur = pHead;
            while(fast != cur) {
                fast = fast.next;
                cur = cur.next;
            }

            return cur;
        }


    }

    // 方法二
    // 快慢指针找到相遇点，这个相遇点一定位于环内
    // 这个相遇点继续遍历直到再遇到字节，通过这样的方式得到环的长度
    // 定义两个指针，第一个先走环长度步，然后两个指针同时走，相遇处就是环入口点
}
