import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 *
 * 思路：
 *      动态规划
 */

public class ValueIsN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int targetNum = 0;
        while(scanner.hasNext()) {
            n = scanner.nextInt();
            targetNum = scanner.nextInt();
        }
//        n = 5;
//        targetNum = 5;

        // 如果n大于targetNum，那么targetNum之后的数字就不用考虑了
        int min = n>targetNum ? targetNum : n;
        ArrayList<Integer> list = new ArrayList<>();
        sum(targetNum, min, list);

        scanner.close();
    }

    public static void sum(int m, int n, ArrayList<Integer> list) {
        if(m == 0) {
            System.out.println(list);
            return;
        }

        if(m<0 || n<=0) {
            return;
        }

        // 通过n-1不断递归到下一层
        ArrayList<Integer> list1 = new ArrayList<>(list);
        sum(m, n-1, list);

        // 这里进行主要的判断
        list1.add(n);
        sum(m-n, n-1, list1);
    }
}
