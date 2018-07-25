import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 方法一：先求出n的阶乘，再将结果从尾至头分析
 * 方法二：上面的方法求阶乘采用递归绝对超时，其实只用找阶乘过程中乘数中包含5的次数就是0的个数
 */

public class NumberOfZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            printNumberOfZero2(n);
        }
//        printNumberOfZero1(20);
    }

    public static void printNumberOfZero1(int n) {
        int num = factorial(n);
        int count = 0;
        String numString = ""+num;
        for (int i = numString.length()-1; i >= 0; i--) {
            if (numString.charAt(i) == '0') {
                count++;
            } else {
                System.out.println(count);
                return;
            }
        }
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num*factorial(num-1);
        }
    }


    public static void printNumberOfZero2(int num) {
        int count = 0;
        for (int i = num; i >= 5; i--) {
            int tmp = i;
            while (tmp%5 == 0) {
                count++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }



}
