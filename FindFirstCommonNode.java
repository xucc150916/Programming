
// 寻找两个单链表的第一个公共节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test {


    // 1. 判断是否有公公节点：遍历到两个链表尾部判断尾节点是否相同
    // 2. 遍历的同时计算出两个链表的长度，然后计算出长度差，长的链表先走长度差步，然后长短链表同时走，相遇点就是第一个公公节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 非法输入
        if(pHead1==null || pHead2==null) {
            return null;
        }
        // 输入的两个链表相同
        if(pHead1 == pHead2) {
            return pHead1;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        // 遍历两个链表得到尾节点并拿到两个链表的长度
        while (cur1.next != null) {
            cur1 = cur1.next;
            len1++;
        }
        len1++;
        while(cur2.next != null) {
            cur2 = cur2.next;
            len2++;
        }
        len2++;
        // 两个链表不相遇
        if(cur1 != cur2) {
            return null;
        }

        cur1 = pHead1;
        cur2 = pHead2;
        // 长的链表先走长度差步，然后长短一起走，相遇点就是第一个重复元素
        if(len1 > len2) {
            int ret = len1-len2;
            for(int i = 0; i < ret; i++) {
                cur1 = cur1.next;
            }

            while(cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            int ret = len2-len1;
            for(int i = 0; i < ret; i++) {
                cur2 = cur2.next;
            }

            while(cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
    }
}
