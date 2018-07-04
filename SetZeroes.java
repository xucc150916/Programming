/**
 * 将二维数组带0的那一行和列设置为全零，空间复杂度为1
 *
 * 方法一：使用第0行第0列作为标记位置，因为如果非零行零列坐标为0，那么该坐标行列全为零，即零行零列对应位置为0，所以可以直接修改
 *         然后便利整个数组，将值为0的点对应的0行0列坐标置为0作为标志，最后统一根据0行0列的标志进行行列的置0
 *
 * 方法二：先遍历整个数组，找到一个为零的点，使用它的对应的行和列作为标记空间，和方法一其实大同小异
 *
 * 方法一要比方法二麻烦一些但是并没有突破性的优点，所以这里演示方法一
 */

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
//                {0,0,0,5},
//                {4,3,1,4},
//                {0,1,1,4},
//                {1,2,1,3},
//                {0,0,1,1}
                {0,1}
        };

        setZeroes(arr);
    }

    // 方法一
    public static void setZeroes(int[][] matrix) {
        // 先判断零行零列是否包含0
        boolean colFlag = false;
        boolean rowFlag = false;
        int col = matrix[0].length;
        int row = matrix.length;
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        for(int i = 0; i < col; i++) {
            if(matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        // 遍历数组，进行判断
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == 0) {
                    // 第0列对应行置0
                    matrix[i][0] = 0;
                    // 第0行对应列置0
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据零行进行数组的置零
        for(int i = 1; i < row; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 根据零列进行数组的置零
        for(int i = 1; i < col; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 零行零列进行处理
        if(colFlag) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if(rowFlag) {
            for(int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }


}
