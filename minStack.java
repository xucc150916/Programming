import java.util.Stack;

/**
 * 最小栈问题
 */

// 方法一，创建两个栈
// 方法二，入栈两个，出栈两个
public class minStack {

    /**
     * 方法一
     */

    // 定义数据栈与最小栈
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if(dataStack.empty()) {
            dataStack.push(node);
            minStack.push(node);
        } else {
            Integer min = minStack.peek();
            if(node < min) {
                dataStack.push(node);
                minStack.push(node);
            } else {
                dataStack.push(node);
                minStack.push(min);
            }
        }
    }

    public void pop() {
        if(dataStack.empty()) {
            return;
        }
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        if(dataStack.empty()) {
            return -1;
        }
        return dataStack.peek();
    }

    public int min() {
        if(dataStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }

    /**
     * 方法二
     */
//    Stack<Integer> stack = new Stack<>();
//
//    public void push(int node) {
//        if(stack.empty()) {
//            stack.push(node);
//            stack.push(node);
//            return;
//        }
//        int min = stack.peek();
//        stack.push(node);
//        if(node < min) {
//            stack.push(node);
//        } else {
//            stack.push(min);
//        }
//    }
//
//    public void pop() {
//        if(stack.empty()) {
//            return;
//        }
//        stack.pop();
//        stack.pop();
//    }
//
//    public int top() {
//        if(stack.empty()) {
//            return -1;
//        }
//        int min = stack.peek();
//        stack.pop();
//        int top = stack.peek();
//        stack.push(min);
//        return top;
//    }
//
//    public int min() {
//        if(stack.empty()) {
//            return -1;
//        }
//        return stack.peek();
//    }

}
