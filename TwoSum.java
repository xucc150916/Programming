/**
 * 给定一个整数数组和一个target，在数组中找到两个数字，它们加起来等于target
 * 函数twoSum应回这两个数字的索引，index1必须小于index2。
 * 请注意，您返回的答案（均为index1和index2）不是从零开始的
 */

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        if(numbers == null) {
            return ret;
        }

        for(int i = 0; i < numbers.length-1; i++) {

            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[i]+numbers[j] == target) {
                    ret[0] = i+1;
                    ret[1] = j+1;
                    return ret;
                }
            }
        }
        return ret;
    }
}
