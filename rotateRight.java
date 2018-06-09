// 给定一个链表和一个非负数k，将链表向右旋转k个位置，从0开始

// 链表定义
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RotateRight {

    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null ||n<1) {
            return head;
        }
        int len = 1;
        ListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        // n可能比链表长度要大
        int k = len-n%len;
        // 将链表连成一个环
        tmp.next = head;
        for(int i = 0; i < k; i++) {
            tmp = tmp.next;
        }
        // 新头节点
        head = tmp.next;
        // 断开环
        tmp.next = null;

        return head;
    }

}