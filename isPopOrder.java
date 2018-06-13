import java.util.Stack;

/**
 * 判断栈的入栈出栈合法性
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 入栈序列为空，返回true
        if(pushA.length == 0) {
            return true;
        }

        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        // 没有出栈完就一直循环
        while (popIndex != popA.length) {
            // 如果栈顶元素不等于出栈序列当前元素或者栈空，就一直入栈
            while(stack.peek()!=popA[popIndex] || stack.empty()) {
                // 入栈序列所有元素都入栈了还没法和出栈序列当前元素匹配，跳出当前循环
                if(pushIndex == pushA.length) {
                    break;
                }
                // 入栈
                stack.push(pushA[pushIndex++]);
            }

            // 与上面while循环中的break对应
            if(stack.peek() != popA[popIndex]) {
                return false;
            }

            stack.pop();
            popIndex++;
        }
        return true;
    }
}
