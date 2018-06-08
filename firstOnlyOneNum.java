// 找出数组中第一个只出现了一次的数字
public class Test {

	public static void main(String[] args) {
		String str = "aaabcd";
		System.out.println(FirstOnlyOneNum_Soluton(str));

	}
	
	public static char FirstOnlyOneNum_Soluton(String str) {
		char[] arr = str.toCharArray();
		int len = str.length();
		// 存储字符串中元素出现的个数
		int[] times = new int[len];
		for(int i = 0; i < len; i++) {
			times[i] = 0;
		}
		
		// 遍历数组
		for(int i = 0; i < len; i++) {
			int cur = arr[i];
			int j = 0;
			// 找到数组中第一次出现cur的下标
			while(arr[j] != cur) {
				j++;
			}
			// 在当前元素第一次出现的位置进行累加
			times[j]++;
			j = 0;
		}
		
		for(int i = 0; i < len; i++) {
			if(times[i] == 1) {
				return arr[i];
			}
		}
		return (char)-1;
	}

}