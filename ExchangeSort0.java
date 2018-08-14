/**
 * 长度为n的数组乱序存放着0至n-1，现在只能进行0与其他数的交换，完成sort方法
 *
 * 解决思路：swapWithZero会将指定的数字与一个0值进行交换，我们要做的就是从头开始将数组中不合适的值用其挪开，然后将属于这个元素的值(下标的值)再挪过来就行了
 */

public class ExchangeSort0 {

    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容

    public void swapWithZero(int[] array, int len, int n) {

        // Main.SwapWithZero(array, len, n);
    }

    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        for (int i = 0; i < len; i++) {
            if (array[i] == i) {
                continue;
            } else {
                swapWithZero(array, len, array[i]);
                swapWithZero(array, len, i);
            }
        }
    }

}
