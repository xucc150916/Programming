package 六月四日;

import java.util.HashSet;
import java.util.Set;

// 寻找数组中重复的元素，使用 duplication 返回任意一个重复元素

public class Test {

    // 1. 使用set集合进行数据的过滤
	// set集合的特点是不能装入重复元素，若装入，则忽略操作
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<>();
		// 遍历整个数组并将元素添加到数组中
        for(int i = 0; i < length; i++) {
            int tmp = numbers[i];
            set.add(tmp);
			// 添加元素之后的set集合长度不等于当前元素个数，证明当前元素为重复值
            if (set.size() != i+1) {
                duplication[0] = tmp;
                return true;
            }
        }
        return  false;
    }

}
