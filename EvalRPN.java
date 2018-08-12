import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 思路：使用两个栈，一个依次存储表达式中的数字，一个一依次存储运算符，运算符出入栈有判定规则
 * 当栈顶为
 */
public class evalRPN {
    public int evalRPN(String[] tokens) {
        // 非法输入
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                stack.add(Integer.parseInt(tokens[i]));
            } catch (NumberFormatException e) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(caculator(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }

    public int caculator(int a, int b, String symbol) {
        switch (symbol) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
        }
        return 0;
    }
}
