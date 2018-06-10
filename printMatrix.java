import java.util.ArrayList;

// 输入一个矩阵，将其从外向内顺时针打印
public class Test {

	public static void main(String[] args) {

		int[][] arr = new int[][] {
			{ 1,  2,  3,  4},
			{ 5,  6,  7,  8},
			{ 9, 10, 11, 12},
			{13, 14, 15, 16}
		};
		printMatrix(arr);

	}

	// 分圈打印
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	    int start = 0;
	    ArrayList<Integer> data = new ArrayList<>();
		int row = matrix.length-1;
		int col = matrix[0].length-1;
	    int rowMax = 0;
	    int colMax = 0;
		
		
		while(start*2<=row && start*2<=col) {
			rowMax = row-start;
			colMax = col-start;
			// 从左向右
			for(int i = start; i <= colMax; i++) {
				data.add(matrix[start][i]);
			}
			// 从上到下
			if(rowMax>start) {
				for(int i = start+1; i <= rowMax; i++) {
					data.add(matrix[i][colMax]);
				}
			}
			// 从右向左
			if(rowMax>start && colMax>start) {
				for(int i = colMax-1; i >= start; i--) {
					data.add(matrix[rowMax][i]);
				}
			}
			// 从下向上
			if(rowMax>start-1 && colMax>start) {
				for(int i = rowMax-1; i > start; i--) {
					data.add(matrix[i][start]);
				}
			}
			start++;
		}
	    for(Integer i : data) {
	    	System.out.println(i);
	    }
		return data;
    }

}