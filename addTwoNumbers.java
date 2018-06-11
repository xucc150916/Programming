

// 链表节点定义
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 链表每个节点包含一个数字，所有的数字组合在一起倒序表示为一个多位数
// 现在输入两个链表，将这两个链表表示的值相加并以这种形式返回一个链表
public class AddTwoNumbers {

    public static void main(String[] args) {
        // 创建测试链表
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        printList(addTwoNumbers(head1, head1));
    }

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        // 1. 得到链表所表示的值
        int result1 = listSum(list1);
        int result2 = listSum(list2);
        int ret = result1+result2;

        System.out.println(ret);

        // 2. 将相加的结果构建成一个链表并返回
        return createListByNum(ret);
    }

    /**
     * 得到链表所表示的值
     * @param head 链表头结点
     * @return 返回这个链表所表示的值
     */
    public static int listSum(ListNode head) {
        if(head == null) {
            return 0;
        }
        ListNode cur = head;
        int ret = 0;
        while(cur != null) {
            ret = ret*10+cur.val;
            cur = cur.next;
        }
        return ret;
    }

    /**
     * 根据给定的值，创建符合题意的链表
     * @param num
     * @return
     */
    public static ListNode createListByNum(int num) {
        // 数字处理
        ListNode head = new ListNode(num%10);
        ListNode pre = head;
        int tmp = num/10;

        while(tmp != 0) {
            // 从最低位到最高为依次存储数字
            ListNode node = new ListNode(tmp%10);
            pre.next = node;
            node.next = null;
            pre = node;
            tmp /= 10;
        }
        return head;
    }


    public static void printList(ListNode head) {
        if(head == null) {
            return;
        }
        System.out.println(head.val);
        printList(head.next);
    }

}
