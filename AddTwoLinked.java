/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 解题思路：
 *      不要被逆序这个要求唬到了，其实还是顺序加的
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoLinked {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 表示两数相加的进位
        int num = 0;
        ListNode cur = new ListNode(0);
        ListNode pre = new ListNode(0);
        // 最后使用pre.next可以找到新链表的头
        pre.next = cur;

        do {
            // 两数之和，将上一轮的进位也处理了
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)+num;
            // 当前位应该的数
            int real = sum % 10;
            // 每次只保存当前轮的进位，因为上面求和已经将进位处理了
            num = sum / 10;

            cur.val = real;

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
            if (l1!=null || l2!=null || num!=0) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }

        } while (l1!=null || l2!=null || num!=0);


        return pre.next;
    }
}