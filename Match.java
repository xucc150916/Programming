/**
 * 正则表达式匹配问题
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {

    public static void main(String[] args) {
        Match match = new Match();
        System.out.println(match.match(",".toCharArray(), ".*".toCharArray()));
    }

    public boolean match(char[] str, char[] pattern) {

        return match(pattern, 0, str, 0);
    }

    public boolean match(char[] pattern, int patternIndex, char[] str, int strIndex) {

        // 正则表达式跑完了，字符串没跑完
        if (patternIndex==pattern.length && strIndex!=str.length) {
            return false;
        }

        // 字符串跑完了，正则表达式没跑完
        if (patternIndex!=pattern.length && strIndex==str.length) {
            return false;
        }

        // 两者都跑完了
        if (patternIndex==pattern.length && strIndex==str.length) {
            return true;
        }

        // 正则表达式下一个字符存在，且为 "*"
        if (patternIndex+1<pattern.length && pattern[patternIndex+1] == '*') {
            // 当前正则表达式为 "." 或者字符匹配
            if (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.') {
                return match(pattern, patternIndex, str, strIndex+1)
                    || match(pattern, patternIndex+2, str, strIndex+1)
                    || match(pattern, patternIndex+2, str, strIndex);
            }
            return match(pattern, patternIndex+1, str, strIndex);
        }

        // 判断
        if (pattern[patternIndex]==str[strIndex] || pattern[patternIndex]=='.') {
            return match(pattern, patternIndex+1, str, strIndex+1);
        }

        return false;
    }
}
