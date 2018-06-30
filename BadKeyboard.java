import java.util.Scanner;

/**
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
 * 肯定坏掉的那些键
 *
 * 输入描述：
 * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
 * 以及下划线“_”（代表空格）组成。题目保证2个字符串均非空
 *
 * 输出描述：
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
 */

public class BadKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入
        String input = scanner.next();
        // 输出
        String output = scanner.next();
        scanner.close();
        whichOne(input, output);
    }

    public static void whichOne(String input, String output) {
        // ret存放坏键
        // char[] ret = new char[input.length()-output.length()];
        char[] ret = new char[256];
        // ret存放元素的个数
        int retLen = 0;

        for(int i = 0, j = 0; i<input.length() && j<output.length(); ) {
            // 相等
            if(input.charAt(i) == output.charAt(j)) {
                System.out.println("i = "+i+", j = "+j);
                i++;
                j++;
            }
            // 不相等
            else {
                boolean flag = true;
                // 判断当前元素是否在ret中出现过
                for(int k = 0; k < retLen; k++) {
                    if(ret[k] == toLower(input.charAt(i))) {
                        flag = false;
                    }
                }
                if(flag) {
                    ret[retLen++] = toLower(input.charAt(i));
                }
                i++;
            }
        }
        // 打印结果
        for(char tmp : ret) {
            System.out.print(tmp);
        }
    }

    /**
     * 大写转小写，小写不管
     * @param c 待转换的字符
     * @return 字符转换之后的int值
     */
    public static char toLower(char c) {
        if(Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        } else {
            return c;
        }
    }

}
