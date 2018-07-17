import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 方法一：使用堆O(nlogk)
 * 方法二：冒泡排序排序，O(n*k)
 * 方法三：快排，O(nlogn)
 */

public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution(new int[]{
                1,2,3,4,5,6,7
        }, 3));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input==null || k==0 || input.length<k) {
            return result;
        }

        // 使用优先队列构建一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // 入堆
        for(int i = 0 ; i < input.length; i++) {
            if(maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else {
                if(maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }

        // 取出堆中的数
        for(int num : maxHeap) {
            result.add(num);
        }

        Collections.sort(result);

        return result;
    }
}
