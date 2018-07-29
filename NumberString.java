/**
 * 实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 * 规律：
 *      A.[B][e/EC]/.[B][]e/EC]
 *      A,C为整数，可以带正负号，B为一个无符号整数，A可以为0
 */

public class NumberString {

    int index = 0;

    public static void main(String[] args) {

    }

    public boolean isNumeric1(char[] str) {

        // 非法输入
        if (str==null || str.length==0) {
            return false;
        }

        // 判断整数部分
        boolean flag = isInteger(str);

        // 指数小数部分
        if (index<str.length && str[index]=='.') {
            index++;
            // 因为可以不包含小数部分，所以这里使用或操作，但是必须让方法要执行，所以把方法的执行放在前面
            flag = isUninteger(str)||flag;
        }

        // 指数部分
        if (index<str.length && (str[index]=='e' || str[index]=='E')) {
            index++;
            // 同上
            flag = isInteger(str)||flag;
        }

        return flag;
    }

    /**
     * 是否为整数
     */
    public boolean isInteger(char[] str) {

        if (index<str.length && (str[index]=='+'||str[index]=='-')) {
            index++;
        }
        return isUninteger(str);

    }

    /**
     * 是否为无符号整数
     */
    public boolean isUninteger(char[] str) {

        int tmpIndex = index;
        while (index<str.length && (str[index]>='0' && str[index]<='9')) {
            index++;
        }

        return index > tmpIndex;
    }

    /**
     * public static double parseDouble(String s) throws NumberFormatException
     * NumberFormatException为一个非受查异常，如果str不是一个浮点数，会抛出该异常，通过这个特性实现函数
     * @param str
     * @return
     */
    public boolean isNumeric2(char[] str) {
        try {
            Double d = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }



}
