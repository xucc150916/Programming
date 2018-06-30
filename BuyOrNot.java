import java.util.Scanner;

/**
 * 小红想买些珠子做一串自己喜欢的珠串。
 * 卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
 * 如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。
 * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 *
 * 输入描述：
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 *
 * 输出描述：
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔
 *
 * 其实就是给定一个字符串，在另一个字符串中查找是否包含指定字符串中所有的字符
 */


public class BuyOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 摊主的珠串
        String actualBead = scanner.next();
        // 小红想要的珠串
        String expectionBead = scanner.next();
        canBuy(actualBead, expectionBead);
        scanner.close();
    }

    public static void canBuy(String actual, String expection) {
        char[] actualArr = new char[256];
        int count = 0;
        // 初始化
        for(int i = 0; i < 256; i++) {
            actualArr[i] = 0;
        }
        // actual中每个字符对应的数值作为actualArr的下标，下标对应的内容为该颜色的数量
        for(int i = 0; i < actual.length(); i++) {
            actualArr[(int)actual.charAt(i)]++;
        }

        for(int i = 0; i < expection.length(); i++) {
            // 遍历期望颜色数组，实际颜色数组中有该颜色，count++，实际颜色数组该颜色数量--
            if(actualArr[expection.charAt(i)] != 0) {
                count++;
                actualArr[expection.charAt(i)]--;
            }
        }

        if(count == expection.length()) {
            System.out.println("Yes "+(actual.length()-count));
        } else {
            System.out.println("No "+(expection.length()-count));
        }

    }
}
