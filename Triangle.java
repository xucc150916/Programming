package com.xucc.每日一题.七月三十一;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 解题思路：
 * 当前行当前下标为i，那么i的值等于上一行当前下标和当前下标前一个值的和
 */

public class Triangle {

    // 方法一：使用一个一位数组充当媒介，将每一行的值赋给数组，然后将数组元素添加进list
    public List<List<Integer>> generate1(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        if (numRows < 1) {
            return lists;
        }

        int[] arr = new int[numRows];
        int pre = 1;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(lists.get(i));
            for (int j = 0; j <= i; j++) {
                int cur = arr[j];
                arr[j] = cur + pre;
                list.add(cur + pre);
                pre = cur;
            }
            lists.add(list);
        }
        return lists;
    }

    // 方法二
    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return lists;
        }

        for (int j = 0; j < numRows; j++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            // 为了防止越界，所以每一行的第一个和最后一个元素都得手动添加，而使用方法一的数组就不会，因为那些元素会自动默认值为0
            for (int i = 1; i < j; i++) {
                // 当前行的上一行
                List<Integer> prevRow = lists.get(j - 1);
                int temp = prevRow.get(i - 1) + prevRow.get(i);
                list.add(temp);
            }
            // 除了第一行，末尾接个1
            if (j != 0) {
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }
}
