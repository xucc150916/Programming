/**
 * 判断一个序列是否为BST的后序遍历
 *
 * BST遍历特性：
 *      中序遍历：从小到大的递增序列
 *      后序遍历：序列最后的根节点可以将前面的序列划分成一部分大于根值，一部分小于根值，找到这个分界点，判断后面大与根值的部分有无小于根值的数，有false，无true，递归判断
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        return verifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean verifySquenceOfBST(int[] sequence, int start, int end) {
        if (sequence ==null || start > end) {
            return false;
        }
        // 当前根节点
        int root = sequence[end];

        int i = start;
        // 寻找root的左半区域范围
        for ( ; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        // 右半区域不能比root值小
        for ( ; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean leftFlag = true;
        // 左半区域存在，递归判断左半区域
        if (i > start) {
            leftFlag = verifySquenceOfBST(sequence, start, i-1);
        }
        boolean rightFlag = true;
        // 右半区域存在，递归判断右半区域
        if (i < end-1) {
            rightFlag = verifySquenceOfBST(sequence, i, end-1);
        }
        return leftFlag && rightFlag;
    }
}
