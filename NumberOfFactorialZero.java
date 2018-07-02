import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 输入描述:
 * 输入为一行，n(1 ≤ n ≤ 1000)
 * 输出描述:
 * 输出一个整数,即题目所求
 */
public class NumberOfFactorialZero {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int baseNumber = scanner.nextInt();
//
//        long factorialNumber = factorial(baseNumber);
//        System.out.println(numberOfZero(factorialNumber));
//    }
    // 方法一：n很大时，效率非常的低
//    /**
//     * 求阶乘
//     * @param n 基数
//     * @return 基数的阶乘
//     */
//    public static long factorial(int n) {
//        if(n < 1) {
//            return 0;
//        }
//        int count = n;
//        long ret = n;
//        while (count > 1) {
//            count--;
//            ret *= count;
//        }
//        return ret;
//    }
//
//    /**
//     * 求number结尾有几个零
//     * @param number 所求的数
//     * @return 结尾零的个数
//     */
//    public static int numberOfZero(long number) {
//        int count = 0;
//        while(number%10 == 0) {
//            count++;
//        }
//        return count;
//    }

    // 方法二：只有2*5=10，而在一个数中，因子2的数量绝对比5多，所以这道题就转换成求阶乘中因子5的个数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int baseNumber = scanner.nextInt();
        int zeroNumber = 0;
        // 求1~baseNumber中能整除5的数，因为只有它们才会包含5
        for(int i = 5; i <= baseNumber; i += 5) {
            int j = i;
            while(j%5 == 0) {
                zeroNumber++;
                j /= 5;
            }
        }
        System.out.println(zeroNumber);
    }


}
