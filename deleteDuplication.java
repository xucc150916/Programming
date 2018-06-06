package 六月五日;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头节点
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

// 链表节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

// 删除链表中重复的结点
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        // 非法输入
        if(pHead == null) {
            return null;
        }

        // 只有一个节点
        if(pHead!=null && pHead.next==null) {
            return pHead;
        }

        ListNode cur = pHead;
        ListNode tmp = null;

        // 当前节点与下一个节点值相等
        if(cur.val == cur.next.val) {
            tmp = cur.next.next;
            // 注意这里的判断条件，要将判空写在前面
            while(tmp!=null && tmp.val==cur.val) {
                tmp = tmp.next;
            }
            return deleteDuplication(tmp);
        } else {
            cur.next = deleteDuplication(cur.next);
            // cur = cur.next;
            return cur;
        }
    }
}
