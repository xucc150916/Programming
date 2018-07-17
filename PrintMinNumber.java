import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class PrintMinNumber {

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();

        System.out.println(printMinNumber.PrintMinNumber(
                new int[] {
                        1, 234,55
                }
        ));
    }

    public String PrintMinNumber(int [] numbers) {
        String ret = "";
        // 非法输入
        if(numbers==null || numbers.length==0) {
            return ret;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                return str1.compareTo(str2);
            }
        });

        // 将排好序的list拼成一个字符串
        for(int num : list) {
            ret += num;
        }

        return ret;
    }
}
