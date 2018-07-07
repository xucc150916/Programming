import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 解题思路：
 * 不管哪种方式的排列组合，无论处于组合的什么阶段，左括号的数目绝对是大于等于右括号数目的，定义left，right表示左右括号数目，进行递归组合
 */

public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n < 1) {
            return list;
        }
        generate(n, n, "", list);
        return list;
    }

    public void generate(int left, int right, String str, ArrayList<String> list) {
        // 组合结束
        if(left==0 && right==0) {
            list.add(str);
            return;
        }

        // 左括号数大于右括号数，出现 ")("，非法情况
        if(left > right) {
            return;
        }

        // 递归组合
        if(left > 0) {
            generate(left-1, right, str+"(", list);
        }
        if(right > 0) {
            generate(left, right-1, str+")", list);
        }
    }

}
