import java.util.Scanner;

/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 */

public class LongestContinuousNumberStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        String numStr = null;
        int numStrIndex = 0;
//        while (scanner.hasNext()) {
//            str = scanner.next();
//        }
        str = "abcd12345ed125ss1234 5678";
        printNumber2(str);


        scanner.close();
    }

    /**
     * 方法一：逐字节遍历整个字符串，使用StringBuidler接收连续的字符串，每当StringBuilder长度超过当前最大的StringBuider长度，将其赋值给numStr字符串最为当前最长的数字字符串
     * @param str
     */
    public static void printNumber1(String str) {
        String numStr = null;
        int numStrIndex = 0;

        // 逐字节遍历字符串
        for(int i = 0; i < str.length(); ) {
            StringBuilder tmp = new StringBuilder();
            if (isNumber(str.charAt(i))) {
                while (i<str.length() && isNumber(str.charAt(i))) {
                    tmp.append(str.charAt(i++));
                }
            } else {
                i++;
            }

            if(tmp.length() > numStrIndex) {
                numStr = tmp.toString();
                numStrIndex = numStr.length();
            }
        }
        System.out.println(numStr);
    }

    /**
     * 方法二：
     * @param str
     */
    public static void printNumber2(String str) {
        // 存储最大数字字符串的长度
        int max = 0;
        // 当前连续子串已经出现了多少个数字
        int count = 0;
        // 最长数字子串结尾下标
        int end = 0;

        for(int i = 0; i < str.length(); i++) {
            if(isNumber(str.charAt(i))) {
                count++;
                if(count > max) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }

        // subString() 左闭右开， 所以截止位置下标要加一，初始下标由截止下标减去长度再加一得来
        System.out.println(str.substring(end-max+1, end+1));

    }


    public static boolean isNumber(char c) {
        if(c>='0' && c<='9') {
            return true;
        }
        return false;
    }
}
