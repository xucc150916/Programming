/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */


public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1));
    }

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }

        // 负数标记
        boolean negative = (x<0);
        if(negative) {
            x = -x;
        }

        // 逆置x
        long num = 0;
        while (x > 0) {
            num = num*10+x%10;
            x /=10;
        }

        if(negative) {
            num = -num;
        }
        // 溢出32位数范围
        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE) {
            return 0;
        }
        return (int)num;
    }
}
