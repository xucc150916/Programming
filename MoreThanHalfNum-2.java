/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 方法一：对数组中每个元素都遍历一次数组，计算元素在数组中出现的次数，时间复杂度为O(n*n)，参见MoreThanHalfNum-1.java
 *
 * 方法二：动态规划，定义一个count变量，遍历整个数组，从第一个元素开始，count代表他出现的次数，之后出现一次++，
 *         出现了其他的--，当count为0，将判断的元素变为下一个元素，重复前面的判断，到最后，只要count>1，就证明当前
 *         判断的元素出现过了半数以上，具体看代码
 */

public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[] {
                1,2,3,2,4,2,5,2,3
        }));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) {
            return 0;
        }

        int number = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == number) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                number = array[i];
                count = 1;
            }
        }

        // 上面的方法是分别不出每种数字出现一次和出现一半次数的情况，所以下面还需要对找到的number进行一次遍历判断
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == number) {
                count++;
            }
        }
        if(count*2 > array.length) {
            return number;
        } else {
            return 0;
        }
    }
}
