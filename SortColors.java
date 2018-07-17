/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class SortColors {
    public void sortColors(int[] A) {
        // 非法输入
        if(A==null || A.length==0) {
            return;
        }

        // 遍历数组，统计出数组中0,1,2的个数
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                zeroCount++;
            } else if(A[i] == 1) {
                oneCount++;
            } else if(A[i] == 2) {
                twoCount++;
            }
        }
        // 对数组进行重排
        for(int i = 0; i < A.length; i++) {
            if(zeroCount > 0) {
                A[i] = 0;
                zeroCount--;
            } else if(oneCount > 0) {
                A[i] = 1;
                oneCount--;
            } else if(twoCount > 0) {
                A[i] = 2;
                twoCount--;
            }
        }

    }

}
