import java.util.ArrayList;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 解题思路：
 */

public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(k > n) {
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        combineCore(n, k, list, 1);
        return lists;
    }

    /**
     * 递归组合
     * @param n 限定组合数字的范围 0~n
     * @param k 组合数字的长度
     * @param list
     * @param index 新一轮的组合从index开始，防止之前组合过了的数字重新参与组合，例如[1, 2]，[2, 1]
     */
    public void combineCore(int n, int k, ArrayList<Integer> list, int index) {
        if(k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i <= n; i++) {
            list.add(i);
            combineCore(n, k-1, list, i+1);
            list.remove(list.size()-1);
        }
    }

}
