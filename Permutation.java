import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 使用递归进行操作，将字符串分成两部分
 */

public class Permutation {

    public static void main(String[] args) {
        System.out.println(new Permutation().Permutation("asdfghkl"));
    }
    
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        // 非法输入
        if(str == null) {
            return list;
        }

        permutationCore(str.toCharArray(), 0, list);

        // 这个鬼题目要求得到的结果是排序的，由于使用的是ArrayList，所以使用Collections提供的静态排序方法进行排序
        Collections.sort(list);
        return list;
    }

    public void permutationCore(char[] charArr, int index, ArrayList<String> list) {
        // 递归交换到字符串最后一个下标处，如果该字符串不包含在list内，则添加
        if(index == charArr.length-1) {
            // 这里注意，由于charArr是一个字符数组，所以在contains比较时要转换为string，因为我们要的是string元素，char和string不能一起比较，大坑
            if(!list.contains(String.valueOf(charArr))) {
                // char数组并没有覆写toStirng()，toString返回的是对象的地址，并不是我们想要的字符串，大坑
                // list.add(charArr.toString());
                list.add(String.valueOf(charArr));
                System.out.println(String.valueOf(charArr));
            }
        } else {
            // 将index下标的字符与之后每一位字符进行交换，然后对剩下的部分再递归交换
            for(int i = index; i < charArr.length; i++) {
                swap(charArr, index, i);
                permutationCore(charArr, index+1, list);
                // 递归之后，要将交换的字符再换回来，一趟for只改变一次位置，防止漏
                swap(charArr, index, i);
            }
        }
    }

    // 交换
    public void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
