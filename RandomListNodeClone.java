/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 解题思路：
 * 1. 将链表所有节点拷贝一份，并且插入到对应的节点后
 * 2. 复制出来的节点的random指向前面节点random.next
 * 3. 分割两个链表
 */


/**
 * 复杂链表的定义
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeClone {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return pHead;
        }

        // 拷贝节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            node.random = null;
            cur.next = node;
            cur = node.next;
        }

        // 拷贝random
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 分开两个链表
        RandomListNode copyHead = pHead.next;
        RandomListNode copyCur = copyHead;
        cur = pHead;
        while (cur != null) {
            cur.next = cur.next.next;
            if (copyCur.next != null) {
                copyCur.next = copyCur.next.next;
            }

            cur = cur.next;
            copyCur = copyCur.next;
        }

        return copyHead;
    }
}




