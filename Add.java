/**
 * 不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Add {
    public int Add(int num1,int num2) {
        while(num2 != 0) {
            // ^ ==> 只考虑加法，不考虑进位
            int tmp = num1^num2;
            // & ==> 只考虑加法的进位，右移一位将进位转移到下一位
            num2 = (num1&num2)<<1;
            num1 = tmp;
        }
        return num1;
    }
}
