import java.util.ArrayList;

// 将数组中所有奇数元素放置在偶数前面，并且相对位置不变

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1,2,3,4,5,6,7
		};
		reOrderArray(arr);
	}
	
	// 冒泡排序式变换位置
	public static void reOrderArray(int [] array) {
		// 为了奇偶相对位置不变，采用冒泡排序进行求解
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				// 后奇前偶就进行交换
				if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}
		return;
	}
	
}