import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 递归进行操作
 */

public class Permutations2 {

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        System.out.println(
                permutations2.permuteUnique(new int[] {
                        1,2,3
                })
        );
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] num) {
        if(num.length == 0) {
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        permutationCore(num, list, 0);
        return lists;
    }

    /**
     * 全排列核心操作，使用递归法
     * @param num
     * @param list
     * @param begin
     */
    public void permutationCore(int[] num, ArrayList<Integer> list, int begin) {
        if(begin == num.length) {
            if(lists.contains(list)) {
                return;
            } else {
                lists.add(new ArrayList<Integer>(list));
                return;
            }
        } else {
            for(int i = begin; i < num.length; i++) {
                swap(num, begin, i);
                list.add(num[begin]);
                permutationCore(num, list, begin+1);
                list.remove(list.size()-1);
                swap(num, begin, i);
            }
        }
    }

    /**
     * 将数组中的a，b下标元素进行交换
     * @param num
     * @param a
     * @param b
     */
    public void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

}
