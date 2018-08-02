import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * <p>
 * 方法一：遍历
 * 方法二：利用等差数列的求和公式来缩小范围
 * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
 * n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
 * 根据等差数列的求和公式：S = (1 + n) * n / 2，得到所需判断的范围为：n < (2s)^(1/2)
 */

public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence find = new FindContinuousSequence();
        System.out.println(find.FindContinuousSequence1(3));
    }

    // 方法一
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // 非法输入
        if (sum < 2) {
            return lists;
        }

        int start = 0;
        int end = 0;
        ArrayList<Integer> list;
        for (int i = 1; i <= sum; i++) {
            list = new ArrayList<>();
            start = i;
            end = i + 1;
            list.add(start);
            while (start <= sum) {
                if (start == sum) {
                    lists.add(list);
                    break;
                }
                list.add(end);
                start += end;
                end++;
            }
        }
        return lists;
    }

    // 方法二
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // 非法输入
        if (sum < 2) {
            return lists;
        }

        for (int i = 2; i < (int) Math.sqrt(2 * sum); i++) {
            if ((i & 1) == 1 && sum % i == 0
                    || (sum % i) * 2 == i) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / i) - (i - 1); j < i; j++, k++) {
                    list.add(k);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
