/**
 * 给定一个排序的整数数组，找到给定目标值的起始和结束位置。
 * 算法的时间复杂度为O（log n）
 * 如果在数组中找不到目标，返回(-1，-1)。
 * 例如,
 * 给定5 7 7 8 8 10和目标值8，
 * 返回(3,4)。
 *
 * 思路：因为规定了时间复杂度，所以这里使用二分查找法进行两个边界的确定
 */

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[]{
                -1, -1
        };

        int min = 0;
        int max = A.length-1;
        // 寻找左边界，min
        while (min < max) {
            int mid = (min+max)/2;
            // min向右逼近
            if(A[mid] < target) {
                min = mid+1;
            } else {
                max = mid;
            }
        }
        // 将A空输入与查找不到两种错误情况归在一起处理
        if(A.length==0 || A[min]!=target) {
            return ret;
        }
        ret[0] = min;

        min = 0;
        max = A.length-1;
        while (min < max) {
            // 因为要确定右边界，这是mid为中点右侧位置
            int mid = (min+max+1)/2;
            // max向左逼近
            if(target < A[mid]) {
                max = mid-1;
            } else {
                // min只是缩小范围，并不逼近
                min = mid;
            }
        }
        ret[1] = max;
        return ret;
    }
}
