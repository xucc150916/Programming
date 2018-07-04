// 数组中出现一一半次数的数字
public class Test {

	public static void main(String[] args) {
		int[] array = new int[] {
				1,2,3,2,2,2,5,4,2
		};
		System.out.println(MoreThanHalfNum_Solution(array));

	}
	
	public static int MoreThanHalfNum_Solution(int [] array) {
		int len = array.length;
		// 存储数组中元素出现的个数
		int[] times = new int[len];
		for(int i = 0; i < len; i++) {
			times[i] = 0;
		}
		
		// 遍历数组
		for(int i = 0; i < len; i++) {
			int cur = array[i];
			// j代表array[i]在array数组中第一次出现的下标
			int j = 0;
			while(array[j] != cur) {
				j++;
			}
			
			// 在times数组中当前元素第一次出现的位置进行累加
			times[j]++;
			j = 0;
		}
		
		for(int i = 0; i < len; i++) {
			if(times[i]*2 > len) {
				return array[i];
			}
		}
		return 0;
	}

}