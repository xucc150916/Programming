/**
 * 求出1~n的数字中出现1的个数
 *
 * 方法一：逐个数字遍历，对每个数字每一位进行判断，时间复杂度为O(n)
 * 方法二：分情况判断)(以一个五位数的百位为例)
 *     （1）：如果百位上数字为0，百位上可能出现1的次数由更高位决定。
 *          比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个
 *          可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（百位，所以是100）
 *     （2）：如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。
 *          比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个，和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。
 *          但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。
 *     （3）：如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定
 *          比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）。
 */

public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        NumberOf1Between1AndN numberOf1Between1AndN = new NumberOf1Between1AndN();
        System.out.println(numberOf1Between1AndN.NumberOf1Between1AndN_Solution2(123));
    }

    // 方法二
    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        if(n < 1) {
            return count;
        }

        // 当前位数
        int index = 1;
        // 低位数
        int lowDigit = 0;
        // 高位数
        int highDigit = 0;
        // 当前位数
        int curDigit = 0;

        // 12345
        while (n/index != 0) {

            highDigit = n/(index*10);
            curDigit = (n/index)%10;
            lowDigit = n-(n/index)*index;

            if(curDigit == 0) {
                count += highDigit*index;
            } else if (curDigit == 1) {
                count += highDigit*index+lowDigit+1;
            } else {
                count += (highDigit+1)*index;
            }
            index *= 10;
        }
        return count;
    }


    // 方法一
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        if(n < 1) {
            return count;
        }
        for(int i = 1; i <= n; i++) {
            String num = ""+i;
            int len = num.length();
            for(int j = 0; j < len; j++) {
                if(num.charAt(j) == '1') {
                    count++;
                }
            }

        }
        return count;
    }



}
