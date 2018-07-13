import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *  给定一个间隔的集合，合并所有重叠的间隔。
 *  例如,
 *  鉴于[1,3],[2,6],[8 10],[15、18],
 *  返回(1,6),[8 10],[15、18]。
 */

/**
 * 间隔定义
 */
class Interval {
    int start;
    int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        // 非法输入
        if(intervals==null || intervals.size()==0) {
            return list;
        }
        // 对intervals排序，因为这里是ArrayList，所以要使用Collections.sort进行排序，自定义比较方法
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                }
                return 0;
            }
        });

        Interval top = intervals.get(0);
        list.add(new Interval(top.start, top.end));
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            top = list.get(list.size()-1);

            // 前一个区间与当前区间重叠，修改list最后一个区间的end
            if(cur.start <= top.end) {
                top.end = Math.max(cur.end, top.end);
            } else {// 没有重叠，将当前区间添加到list中
                list.add(new Interval(cur.start, cur.end));
            }
        }
        return list;
    }
}
