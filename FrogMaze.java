import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
 * 为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。
 * 小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
 * 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,
 * 当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 * 
 * 输入描述:
 * 输入包括n+1行:
 *  第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 *  接下来的n行:
 *  每行m个0或者1,以空格分隔
 * 输出描述:
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 *
 * 输入
 * 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 * 输出
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */

public class FrogMaze {


    static int n = 0;
    static int m = 0;
    // 当前求解方案走完剩余的能量
    static int maxResidueEnergy = 0;

    // 迷宫地图
    static int[][] map;

    // 是否能出去
    static boolean canSolve = false;

    // 路径
    static String path = "";

    // 保存当前走过的点
    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        // 输入操作
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int p = scanner.nextInt();
            map = new int[n][m];

            // 迷宫地图录入
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            enterMaze(0, 0, p);

            if (canSolve) {
                System.out.println(path);
            } else {
                System.out.println("Can not escape!");
            }
        }
    }

    public static void enterMaze(int x, int y, int energy) {
        // 递归越界，能量耗完，当前点不能走
        if (energy<0 || x<0 || y<0 || x>=n || y>=m || map[x][y]==0) {
            return;
        } else {

            linkedList.push("["+x+", "+y+"]");

            // 将当前块记0，使之后的点不能再走
            map[x][y] = 0;

            // 当前找到了出口
            if (x==0 && y==m-1) {
                // 本次方案剩余的能量值比当前花费最少的方案剩余的能量还多，进行最优路径的更新
                if (energy >= maxResidueEnergy) {
                    maxResidueEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1;
                canSolve = true;
                return;
            }

            // 向上
            enterMaze(x-1, y, energy-3);
            // 向右
            enterMaze(x, y+1, energy-1);
            // 向下
            enterMaze(x+1, y, energy);
            // 向左
            enterMaze(x, y-1, energy-1);

            map[x][y] = 1;
            linkedList.removeLast();
        }
    }

    /**
     *
     */
    public static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        path = sb.toString();
    }

}
