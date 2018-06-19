/**
 * 一个栈依次压入1,2,3,4,5那么从栈顶到栈底分别为5,4,3,2,1。
 * 将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现了栈中元素的逆序，
 * 请设计一个算法实现逆序栈的操作，但是只能用递归函数来实现，而不能用另外的数据结构。
 * 即给定一个栈stack以及栈的大小top，请返回逆序后的栈。
 */

public class ReverseStackRecursively {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3
        };
        reverseStackRecursively(arr, arr.length);
        for(int a : arr) {
            System.out.println(a);
        }
    }

    public static int[] reverseStackRecursively(int[] stack, int top) {
        int[] array = new int[top];
        reverseStackRecursivelyCore(stack, 0, array);
        return array;
    }

    private static void reverseStackRecursivelyCore(int[] stack, int stackIndex, int[] array) {

        if(stackIndex != stack.length-1) {
            reverseStackRecursivelyCore(stack, stackIndex+1, array);
        }
        array[stack.length-1-stackIndex] = stack[stackIndex];
    }
}