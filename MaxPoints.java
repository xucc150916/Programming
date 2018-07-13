/**
 * 求一组坐标中坐标点数最多直线上的点的数目
 *
 * 暴力求解，两层循环创构建出所有可能存在的直线，第三层循环遍历整个点集，判断这个点是否存在在该直线上
 * 时间复杂度为O(n*n*n)，空间复杂度为0(n)
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPoints {

    public static void main(String[] args) {
        Point[] arr = new Point[] {
                new Point(0, 0),
                new Point(1, 65536),
                new Point(65536, 0),
        };
        MaxPoints maxPoints = new MaxPoints();
        maxPoints.maxPoints(arr);
    }

    public int maxPoints(Point[] points) {
        // 非法输入
        if(points.length==0 || points==null) {
            return 0;
        }

        // 只能组成或者不能组成一条直线
        if(points.length < 3) {
            return points.length;
        }

        // 所有的元素值都一样，要特殊处理
        if(allEqual(points)) {
            return points.length;
        }
        int count = 2;
        for(int i = 0; i < points.length-1; i++) {
            for(int j = i+1; j < points.length; j++) {
                // 以points[i], points[j]为端点，遍历数组中所有点，判断是否能组成直线，cur记录本轮构成直线点的数目
                int cur = 2;

                for(int k = 0; k < points.length; k++) {
                    // 重复点
                    if((points[k].x==points[i].x)&&(points[k].y==points[i].y)
                            || (points[k].x==points[j].x)&&(points[k].y==points[j].y)) {
                        continue;
                    }
                    /**
                     * 构成直线的要求是
                     * (y1-y2)/(x1-x2) = (y2-y3)/(x2-x3)
                     * 因为这里用除法可能会造成分母为零，抛出算数异常ArithmeticException，所以将其改为乘法
                     * (y1-y2)(x2-x3) = (y2-y3)/(x1-x2)
                     */
                    if((points[k].y-points[j].y)*(points[j].x-points[i].x)
                            == (points[j].y-points[i].y)*(points[k].x-points[j].x)) {
                        cur++;
                    }
                }
                if(cur > count) {
                    count = cur;
                }
                cur = 2;
            }
        }
        return count;
    }

    public boolean allEqual(Point[] point) {
        Point std = point[0];
        for(Point tmp : point) {
            if(std.x!=tmp.x || std.y!=tmp.y) {
                return false;
            }
        }
        return true;
    }

}
