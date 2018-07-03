/**
 * 搜索旋转有序数组
 * 一个有序数组经过旋转后得到的数组，每个元素可能重复。在其中搜索指定元素，查找到了返回true，否则false
 * @author xuche
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {
                1, 1, 3, 1
        };
        System.out.println(search(arr, 3));
    }

    public static boolean search(int A[], int target) {
        if(A == null) {
            return false;
        }

        int min = 0;
        int max = A.length-1;

        while (min <= max) {
            int mid = (min+max)/2;

            if(A[mid] == target) {
                return true;
            }

            // 防止
            if(A[min]==A[mid] && A[mid]==A[max]) {
                for(int i = 0; i < A.length; i++ ) {
                    if(A[i] == target) {
                        return true;
                    }
                }
                return false;

            } else if(A[min] <= A[mid]) {
                // 左侧有序，则在左侧使用二分查找
                if(target>=A[min] && target<A[mid]) {
                    max = mid-1;
                } else {
                    min = mid+1;
                }
            } else {
                // 右侧，二分查找
                if(target>A[mid] && target<=A[max]) {
                    min = mid+1;
                } else {
                    max = mid-1;
                }
            }
        }
        return false;
    }

}
