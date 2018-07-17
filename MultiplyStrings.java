import java.math.BigInteger;

/**
 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

 示例 1:

 输入: num1 = "2", num2 = "3"
 输出: "6"
 示例 2:

 输入: num1 = "123", num2 = "456"
 输出: "56088"
 说明：

 num1 和 num2 的长度小于110。
 num1 和 num2 只包含数字 0-9。
 num1 和 num2 均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("123","456"));
    }

    public String multiply(String num1, String num2) {
        // 非法输入
        if(num1==null || num2==null) {
            return null;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1+len2;
        // 两个字符串相乘，得到的结果最大位数不可能超过len1+len2
        int[] num = new int[len];

        // 字符串相乘，不考虑进位。注意：字符串低位保存数值高位数据，字符串高位保存数值低位数据
        for(int i = len1-1; i >= 0; i--) {
            for(int j = len2-1; j >= 0; j--) {
                // num数组的保存书序与字符串一致，这里加一的目的是让数字靠向数组的高位，方便后面转换为字符串时的处理
                num[i+j+1] += (int)(num1.charAt(i)-'0') * (int)(num2.charAt(j)-'0');
            }
        }

        // 进位处理
        int tmp = 0;
        for(int i = len-1; i >= 0; i--) {
            // 将前一位的进位加上来
            num[i] += tmp;
            // 如果当前位超过9，tmp就会将除了各位之外的进位传递给下一位
            tmp = num[i]/10;
            // tmp已经带走了当前位的进位，所以使用求模操作当前位的进位
            num[i] = num[i]%10;
        }

        // 将num数组的结果转换为字符串
        boolean firstZero = true;
        String res = "";
        for(int i = 0; i < len; i++) {
            if(firstZero && num[i]==0) {
                continue;
            } else {
                firstZero = false;
                res += num[i];
            }
        }
        if(firstZero) {
            return "0";
        }
        return res;
    }

}
