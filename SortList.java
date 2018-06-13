/**
 * 时间复杂度为O (nlogn)，空间复杂度为常量的链表排序
 */

// 链表节点类定义

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 1. 使用快慢指针找到链表的中点，以中点为界将链表分开
// 2. 递归对每个链表进行排序
// 3. 合并

 public class SortList {

     public static void main(String[] args) {
         ListNode head1 = new ListNode(3);
         ListNode node2 = new ListNode(4);
         ListNode node3 = new ListNode(1);
         ListNode node4 = new ListNode(2);

         head1.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = null;

         // 测试
         head1 = sortList(head1);
         while (head1 != null) {
             System.out.println(head1.val);
             head1 = head1.next;
         }
     }

    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        // 找到链表中点
        ListNode mid = findMiddle(head);

        // 划分左右链表
        ListNode rightList = sortList(mid.next);
        mid.next = null;
        ListNode leftList = sortList(head);

        // 合并并排序两个链表
        return mergeList(leftList, rightList);
    }

    public static ListNode findMiddle(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        if(slow.next != null) {
            fast = fast.next;
        } else {
            return head;
        }

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode newHead;
        if(cur1.val < cur2.val) {
            newHead = cur1;
            cur1 = cur1.next;
        } else {
            newHead = cur2;
            cur2 = cur2.next;
        }
        ListNode cur = newHead;
        while (cur1!=null && cur2!=null) {
            if(cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if(cur2 == null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }

        return newHead;
    }
}
