package com.xucc.每日一题.七月二十五;

import java.util.Scanner;
import java.util.Stack;

/**
 * 进制转换
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 *
 * 输入描述:
 * 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 * 输出描述:
 * 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 *
 * 输入
 * 7 2
 * 输出
 * 111
 *
 * @author xucc
 */
public class ConversionSystems  {

    // 如果进制大于10，就要用字母表示数字
    public static String[] numTable = new String[] {
            "A", "B", "C", "D", "E", "F"
    };

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int num = scanner.nextInt();
//            int base = scanner.nextInt();
//            printConversion(num, base);
//        }
        printConversion(4095, 16);

    }

    /**
     * 将十进制的num转换为base进制数，并打印
     * @param num 十进制数
     * @param base 需要转换的进制数
     */
    public static void printConversion(int num, int base) {
        int tmp = num;
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        if (base == 10) {
            System.out.println(num);
            return;
        }

        while (tmp != 0) {

            int yushu = tmp%base;
            // 小于十进制，不涉及字符表示数字
            if (base < 10) {
                stack.push(yushu+"");
            } else {// 大于十进制
                stack.push(yushu > 9 ? numTable[yushu-10] : yushu+"");
            }
            tmp /= base;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop().toString());
        }

        System.out.println(sb);
    }
}