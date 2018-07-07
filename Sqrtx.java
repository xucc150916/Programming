/**
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 解题思路：
 * 使用牛顿迭代法进行求解
 */

public class Sqrtx {

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.sqrt(169));
    }

    public int sqrt(int x) {
        double value = x;
        double pre = 0.0;

        // 牛顿迭代法求开方
        while (value != pre) {
            pre = value;
            value = (value + x/value)/2;
        }
        return (int)value;
    }
}

