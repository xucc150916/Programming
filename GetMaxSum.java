/**
 * 求最大连续数列和
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
 * 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 *
 * 贪心算法，每一步都求出局部最优解，那么总体就可以达到最优解
 */

public class GetMaxSum {

    public static void main(String[] args) {
        System.out.println(
                getMaxSum(
                        new int[] {
                                -2,-4,-3,-4,-1
                        }, 5
                )
        );
    }

    public static int getMaxSum(int[] A, int n) {
        // 非法输入
        if(A==null || A.length==0) {
            return 0;
        }

        int maxValue = A[0];
        int curValue = 0;

        for(int i = 0; i < A.length; i++) {
            curValue += A[i];

            if(curValue > maxValue) {
                maxValue = curValue;
            }
            // 如果当前最大和为负数，那么就从下一个重新开始计数
            if(curValue < 0) {
                curValue = 0;
            }
        }
        return maxValue;
    }

    public static int getMaxSum1(int[] A, int n) {
        // 非法输入
        if(A==null || A.length==0) {
            return 0;
        }

        int maxValue = A[0];
        int curValue = A[0];
        for(int i = 0; i < A.length; i++) {
            // 如果是正数，加入curValue中，如果是负数，将其和其后面紧跟的所有负数加入
            if(A[i] >= 0) {
                curValue += A[i];
            } else {
                while (i<A.length && A[i]<0) {
                    curValue += A[i++];
                }
                // 如果达到连续负数后没有正数，则返回当前maxValue
                if(i == A.length) {
                    return maxValue;
                }
                curValue += A[i];
            }

            if(curValue > maxValue) {
                maxValue = curValue;
            }
        }
        return maxValue;
    }
}


