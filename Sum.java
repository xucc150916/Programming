/**
 * 求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 使用 && 短路与进行判断，这里要注意&&与&的区别。&&为短路操作符，第一个为真后面的不进行运算，&不管第一个真假，都进行运算
 */

public class Sum {

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.Sum_Solution(10));
    }

    public int Sum_Solution(int n) {
        int num = n;
        num = function(n, 0);
        return num;
    }

    public int function(int n, int sum) {
        sum = sum+n;
        boolean flag = true;
        // 使用 && 进行判断操作，&&为短路操作
        flag = (n > 0) && ((sum=function(--n, sum)) > 0);
        return sum;
    }
}
