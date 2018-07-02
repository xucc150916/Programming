import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * 给定两个单词（开始和结束）和一个字典，从开始到结束，找到最短转换序列的长度，这样：
 * Only one letter can be changed at a time
 * 一次只能换一个字母
 * Each intermediate word must exist in the dictionary
 * 每个中间词都必须存在于字典中
 * For example,
 * 例如,
 * Given:
 * 给
 * start ="hit"
 * 开始= "打击"
 * end ="cog"
 * 结束=“齿轮”
 * dict =["hot","dot","dog","lot","log"]
 * dict =[“热”、“点”、“狗”、“很多”,“日志”)
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 一个最短的变换是“击中”——“热”——“点”——“狗”——“齿轮”，
 * return its length5.
 * 返回其length5。
 * Note:
 * 注意:
 * Return 0 if there is no such transformation sequence.
 * 如果没有这样的转换序列，返回0。
 * All words have the same length.
 * 所有单词的长度相同。
 * All words contain only lowercase alphabetic characters.
 * 所有单词都只包含小写字母字符。
 */


public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int res = 1;
        // 创建队列
        LinkedList<String> queue = new LinkedList<>();
        // 入队列start
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                // 出栈队首，本次循环，使用front与后面的进行置换
                String front = queue.poll();
                size--;

                // 和end只有一个字符不同，所以可以直接步数+1返回
                if(isDiffOne(front, end)) {
                    return res+1;
                }

                // 使用迭代器遍历dict
                Iterator<String> iterator = dict.iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    if(isDiffOne(s, front)) {
                        // 入队列
                        queue.offer(s);
                        // 删除dict当前单词
                        iterator.remove();
                        break;
                    }
                }
            }
            res++;
        }
        return 0;
    }

    /**
     * 判断两个字符串字符是否只有不同
     * @param str1 字符串1
     * @param str2 字符串2
     * @return true/false
     */
    public boolean isDiffOne(String str1, String str2) {
        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count==1 ? true : false;
    }
}
