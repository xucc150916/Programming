import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 *      方法一：遍历判断
 *      方法二：在已有丑数的基础上，推算出其他丑数
 */

public class GetUglyNumber {

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.GetUglyNumber_Solution2(10));
    }

    public int GetUglyNumber_Solution1(int index) {
        // 非法输入
        if(index < 1) {
            return -1;
        }
        if(index == 1) {
            return 1;
        }
        int count = 2;
        for( ; index > 1; count++) {
            if(isUgly(count)) {
                index--;
            }
        }
        return count;
    }

    /**
     * num是否为丑数，只能被2,3,5整除
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        while (num%2 == 0) {
            num /= 2;
        }
        while (num%3 == 0) {
            num /= 3;
        }
        while (num%5 == 0) {
            num /= 5;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }


    public int GetUglyNumber_Solution2(int index) {
        // 非法输入
        if(index < 1) {
            return -1;
        }
        if(index == 1) {
            return 1;
        }
        // 将所有丑数保存到list中
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        // 分别对应丑数的三个因子2,3,5
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        while (list.size() < index) {
            // 在已有丑数1的基础上，乘上基数，推算出下一个丑数
            int m1 = list.get(n1)*2;
            int m2 = list.get(n2)*3;
            int m3 = list.get(n3)*5;
            // 最小的数为下一个丑数
            int nextUgly = Math.min(m1, Math.min(m2, m3));
            list.add(nextUgly);

            // 更新对应的丑数基数
            if(m1 == nextUgly) {
                n1++;
            }
            if(m2 == nextUgly) {
                n2++;
            }
            if(m3 == nextUgly) {
                n3++;
            }
        }
        return list.get(list.size()-1);
    }


    }
