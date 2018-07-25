import java.util.ArrayList;

/**
 * 输入一个字符串。
 * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
 */
public class LongestContinuousNumberStr2 {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.next();
//            printLongestStr(str);
//        }
        printLongestStr2("a123b123c1");
    }

    /**
     * 方法一：动态监测
     * @param str
     */
    public static void printLongestStr1(String str) {
        // 非法输入
        if (str == null) {
            System.out.println("");
        }
        int count = 0; // 当前数字子串长度
        int max = 0;   // 当前最长数字子串长度
        int end = 0;   // 最长的数字字串结束下标
        ArrayList<String> list = new ArrayList<>();

        // 遍历整个字符串，得到上面的数据
        for (int i = 0; i < str.length(); i++) {
            if (isNumber(str.charAt(i))) {
                count++;

                if (count >= max) {
                    max = count;
                    end = i;
                    String ret = str.substring(end-max+1, end+1);
                    list.add(ret);
                }
            } else {
                count = 0;
            }
        }

        // 获得所需要的输出格式
        int leastElemSize = list.get(list.size()-1).length();
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).length() == leastElemSize) {
                sb.append(list.get(i)).append(",");
                tmp++;
            } else {
                sb.append(tmp);
                System.out.println(sb);
                return;
            }
        }
    }

    /**
     * 将数字字符串两侧用字母a替换，然后按a进行字符串的分割，最后对这些分开的字符串进行处理
     * @param str
     */
    public static void printLongestStr2(String str) {
        // 非法输入
        if (str == null) {
            return;
        }

        // 将字符串中的字符全部用a代替
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (isNumber(c)) {
                sb.append(c);
            } else {
                // 分隔
                sb.append('a');
            }
        }

        // 以 "a" 将sb切分成数组
        String[] result = sb.toString().split("a");
        int maxSize = 0;
        // 找到最大长度
        for (String s : result) {
            maxSize = (maxSize>s.length() ? maxSize : s.length());
        }
        // 按照输出格式输出结果字符串
        int tmp = 0;
        for (String s : result) {
            if (s.length() == maxSize) {
                System.out.print(s+",");
                tmp++;
            }
        }
        System.out.print(tmp);
    }

    /**
     * 传入字符是否为数字
     */
    public static boolean isNumber(char c) {
        if (c>='0' && c<='9') {
            return true;
        }
        return false;
    }

}