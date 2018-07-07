/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射与电话按键相同, 2-abc, 3-def, ...。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 解题思路：
 * 和之前的 "给定一个字符串，求出该字符串所有的字符排列组合" 类似，这里也采用递归的方式，指定一个index来指向当前递归字符串的下标
 * 将字符串每个字符进行递归组合，组合的范围是题目给定的数字对应的字符
 */

import java.util.ArrayList;

public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }

    // 数字对应的字符
    String[] table = new String[] {
            "","","abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
    };

    // 存放组合之后的字符
    StringBuilder sb = new StringBuilder();

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }

        combinations(digits, result, 0);
        return result;
    }

    public void combinations(String digital, ArrayList<String> result, int index) {
        // index到达字符串尾，递归组合完成
        if(index == digital.length()) {
            result.add(sb.toString());
            return;
        } else {
            // 当前数字
            int number = digital.charAt(index)-'0';
            // 递归组合
            for(int i = 0; i < table[number].length(); i++) {
                sb.append(table[number].charAt(i));
                combinations(digital, result, index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
