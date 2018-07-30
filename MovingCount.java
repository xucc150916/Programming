/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 回溯
 */

public class MovingCount {

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(10, 1, 100));
    }


    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols];
        return movingCount(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCount(int threshold, int rows, int cols, int rowIndex, int colIndex, boolean[][] visited) {

        if (rowIndex < 0 || rowIndex >= rows
                || colIndex < 0 || colIndex >= cols
                || visited[rowIndex][colIndex]
                || bitCount(rowIndex) + bitCount(colIndex) > threshold) {
            return 0;
        }
        // 标记该点走过
        visited[rowIndex][colIndex] = true;

        return movingCount(threshold, rows, cols, rowIndex + 1, colIndex, visited)
                + movingCount(threshold, rows, cols, rowIndex - 1, colIndex, visited)
                + movingCount(threshold, rows, cols, rowIndex , colIndex+1, visited)
                + (movingCount(threshold, rows, cols, rowIndex , colIndex-1, visited) + 1);
    }


    public int bitCount(int n1) {
        int sum = 0;
        while (n1 > 0) {
            sum += (n1 % 10);
            n1 /= 10;
        }
        return sum;
    }

}
