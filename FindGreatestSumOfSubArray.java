/**
 * 求连续数组中和最大的子数组，数组元素可能会出现负数
 */

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0) {
            return 0;
        }

        int maxNumber = array[0];
        int curNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (curNumber <= 0) {
                curNumber = array[i];
            } else {
                curNumber += array[i];
            }

            if(curNumber > maxNumber) {
                maxNumber = curNumber;
            }
        }
        return maxNumber;
    }
}
