/**
 * 给定一个链表和一个值x，对它进行分区，使得小于x的所有节点都在大于或等于x的节点之前.
 * 保留两个分区中的每一个节点的原始相对顺序。
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


// 方法一，遍历链表找到第一个大于或者等于x的节点前一个节点，然后遍历，将所有小于x的节点插入到它的后面
// 方法二，创建两个链表before，after，将小于x的节点插入到before链表，其余插入after，然后合并
public class Partition {

    public static void main(String[] args) {
        // 创建链表
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        // 测试
        head1 = partition(head1, 2);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }


    }

    // 方法1
    public static ListNode partition(ListNode head, int x) {

        if(head == null) {
            return head;
        }
        ListNode cur = head;

        // 创建一个新的根节点，它的next指向head
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode boundary = preHead;
        // 遍历链表，寻找边界节点前面的点(val >= x)
        while (cur!=null && cur.val<x) {
            boundary = cur;
            cur = cur.next;
        }
        // 遍历完整个链表，都没有找到符合条件的边界节点，返回null
        if(boundary.val > x) {
            System.out.println("ji");
            return null;
        }

        cur = boundary.next;
        ListNode pre = boundary;
        while (cur != null) {
            ListNode tmp = cur;
            // 当前节点小于x，将其插入到boundary后面，并且boundary后移
            if(cur.val < x) {
                cur = cur.next;
                pre.next = cur;

                tmp.next = boundary.next;
                boundary.next = tmp;
                boundary = tmp;

            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return preHead.next;
    }

}
