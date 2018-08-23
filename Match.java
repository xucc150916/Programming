/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class match {
    public static void main(String[] args) {
        String str = "";
        String pattern = ".";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

        // 同时结束
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        // str是不会先于pattern结束的，这种情况不考虑，只考虑pattern先结束的情况
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }


        // pattern下一个为 '*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                // 当前字符匹配
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex) ||
                        matchCore(str, strIndex, pattern, patternIndex + 2);
            }
            return matchCore(str, strIndex, pattern, patternIndex + 2);
        }

        // 字符
        if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }


}
