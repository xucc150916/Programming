import java.util.Arrays;
import java.util.Scanner;

/**
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数
 * 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 *
 * 输入包括m+2行。
 * 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 *
 * 输出描述:
 * 输出一个整数,表示最大的总预计消费金额
 * 输入
 * 3 5
 * 2 4 2
 * 1 3
 * 3 5
 * 3 7
 * 5 9
 * 1 10
 *
 * 输出
 * 20
 *
 * 解决思路：
 *      将桌子和顾客分别抽象成两个类，对它们进行排序，然后进行二分查找
 */

/**
 * 桌子类
 */
class Table implements Comparable {

    // 可容纳人数
    public int number;
    // 是否被占用
    public boolean flag;

    public Table(int number) {
        this.number = number;
        this.flag = false;
    }

    /**
     * 将Table按升序排列
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Table t = (Table) o;
        if (this.number > t.number) {
            return 1;
        } else if (this.number == t.number) {
            return 0;
        } else {
            return -1;
        }
    }
}


/**
 * 客户类
 */
class Customer implements Comparable {

    // 人数
    public int number;
    // 预期消费
    public int spent;
    // 是否吃过了
    public boolean flag;

    public Customer() {}


    public Customer(int number, int spent) {
        this.number = number;
        this.spent = spent;
        flag = false;
    }


    /**
     * 将消费最高的排最前，碰到消费相同的，按用餐人数升序排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Customer t = (Customer)o;
        if (this.spent > t.spent) {
            return -1;
        } else if (this.spent < t.spent) {
            return 1;
        } else {
//            return this.number>=t.number ? 1 : 0;
            if (this.number > t.number) {
                return 1;
            } else if (this.number < t.number) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}


public class RestaurantProblem {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        // 桌子数
//        int n = scanner.nextInt();
//        // 客人批数
//        int m = scanner.nextInt();
//        // 桌子最大容纳数量
//        Table[] tables = new Table[n];
//        // 客人数组
//        Customer[] customers = new Customer[m];
//
//        // 存储桌子容量
//        for (int i = 0; i < n; i++) {
//            tables[i] = new Table(scanner.nextInt());
//        }
//        // 存储客人信息
//        for (int i = 0; i < m; i++) {
//            customers[i] = new Customer(scanner.nextInt(), scanner.nextInt());
//        }
//        scanner.close();

        // 桌子数
        int n = 3;
        // 客人批数
        int m = 5;

        // 桌子最大容纳数量
        Table[] tables = new Table[n];
        tables[0] = new Table(2);
        tables[1] = new Table(4);
        tables[2] = new Table(2);

        // 客人数组
        Customer[] customers = new Customer[m];
        customers[0] = new Customer(1, 3);
        customers[1] = new Customer(3, 5);
        customers[2] = new Customer(3, 7);
        customers[3] = new Customer(5, 9);
        customers[4] = new Customer(1, 10);

        // 总消费
        long sumSpent = 0;
        // tables升序排列
        Arrays.sort(tables);
        // customers消费降序，消费相同，人数升序排列
        Arrays.sort(customers);
        // 当前做了几桌
        int count = 0;

        /**
         * 依次对每批用餐人员处理(二分查找)
         * 1. 先找到用餐人数跟桌子最大容纳人数相等的桌子，
         * 如果该桌子已经被使用，则找跟该桌子最大容纳人数相等的并且没有人坐的桌子，如果找到则坐下，标记桌子为已使用
         * 如果发现跟该桌子最大容纳人数相等的桌子都已经被使用，则往容纳更多人数的桌子依次往上找，直到找到未使用的桌子坐下或没有桌子的时候停止
         * 2. 如果mid没找到用餐人数跟桌子最大容纳人数相等的桌子，则l往容纳更多人数的桌子依次往上找，直到找到未使用的桌子坐下或没有桌子的时候停止
         * 当所有桌子已使用时可以提前停止。
         */
        for (int i = 0; i < m; i++) {
            // 桌子坐满了
            if (count == n) {
                break;
            }
            int l = 0;
            int r = n-1;
            while (l <= r) {
                int mid = l+(r-l)/2;

                // mid桌容纳不了当前批客人
                if (tables[mid].number < customers[i].number) {
                    l = mid+1;
                } else if (tables[mid].number > customers[i].number) {
                    // mid桌人数大于当前批客人
                    r = mid-1;
                } else {
                    // 当前桌没有被占用
                    if (!tables[mid].flag) {
                        sumSpent += customers[i].spent;
                        tables[mid].flag = true;
                        count++;
                        break;
                    } else{
                        // 当前桌被占用

                        int temp = mid-1;
                        // 向前找一个没有被占的桌子
                        while (temp>=0
                                && tables[temp].flag==true
                                && tables[temp].number==tables[mid].number) {
                            temp--;
                        }

                        // 如果在前面找到了一个没有被占且刚好容纳的桌子，进行添加
                        if(temp>=0
                                && tables[temp].flag==false
                                && tables[temp].number == tables[mid].number){
                            sumSpent += customers[i].spent;
                            tables[temp].flag = true;
                            count++;
                            break;
                        }

                        // 向前找没找到，这时向后找，哪怕浪费座位
                        while(mid<=n-1
                                && tables[mid].flag==true) {
                            mid++;
                        }

                        // 向后也找不到，放弃这个客人
                        if(mid > n-1) {
                            break;
                        }

                        // 找到了座位
                        sumSpent += customers[i].spent;
                        tables[mid].flag = true;
                        count++;
                        break;
                    }
                }
            }

            // 上面的二分查找找不到刚好容纳的座位，以l为基准向后遍历查找没用过的桌子
            if(l>r){
                // 向后找
                while(l<=n-1
                        && tables[l].flag==true) {
                    l++;
                }
                if(l<=n-1){
                    sumSpent += customers[i].spent;
                    tables[l].flag = true;
                    count++;
                }

            }
        }
        System.out.println(sumSpent);

    }
}
