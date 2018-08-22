import java.util.Scanner;

/**
 * 找出非空字符串中第一个只出现了一次的字符
 *
 * 方法一：遍历查找
 * 方法二：indexOf和lastIndexOf
 */
public class FindOneTimes {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            solution1(str);
        }
    }

    public static void solution1(String str) {
        // 按字符串顺序存储每个字符出现的个数
        int[] arr = new int[str.length()];

        // 初始化数组
        for (int i = 0; i < str.length(); i++) {
            arr[i] = 0;
        }


        for (int i = 0; i < str.length(); i++) {
            // 将字符串中第一个出现当前字符的下标的值+1，如果没出现，就在当前位置处建立
            for (int j = 0; j <= i; j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    arr[j]++;
                    break;
                }
            }
        }

        // 遍历数组，第一个值为1的地方就是想要的下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(str.charAt(i));
                return;
            }
        }
        System.out.println(-1);
    }

    /**
     * 使用String.index()和String.lastIndexOf()
     * @param str
     */
    public static void solution2(String str) {
		String s = scanner.nextLine();
            int i = 0;
            for (i = 0; i < s.length(); i++) {
                String tmp = s.charAt(i) + "";
                if (s.indexOf(tmp) == s.lastIndexOf(tmp)) {
                    System.out.println(tmp);
                    break;
                }
            }
            if (i == s.length()) {
                System.out.println(-1);
            }
    }

}
