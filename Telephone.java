/**
 * 电话的九宫格，一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。
 * 例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。
 * 同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
 *
 * NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。
 *
 * 输入描述(输入包含多组数据)：
 * 每组数据第一行包含一个正整数n（1≤n≤1024）。
 * 紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
 * 没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。
 *
 * 输出描述:
 * 对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。
 * 每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
 *
 * 示例1
 * 输入
 * 12
 * 4873279
 * ITS-EASY
 * 888-4567
 * 3-10-10-10
 * 888-GLOP
 * TUT-GLOP
 * 967-11-11
 * 310-GINO
 * F101010
 * 888-1200
 * -4-8-7-3-2-7-9-
 * 487-3279
 *
 * 4
 * UTT-HELP
 * TUT-GLOP
 * 310-GINO
 * 000-1213
 *
 * 输出
 * 310-1010
 * 310-4466
 * 487-3279
 * 888-1200
 * 888-4567
 * 967-1111
 *
 * 000-1213
 * 310-4466
 * 888-4357
 * 888-4567
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Telephone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] map = new String[]{
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "22233344455566677778889999"
        };

        while (scanner.hasNext()) {
            // 本组数据行数
            int n = scanner.nextInt();
            Set<String> set = new TreeSet<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                // 将输入的字符串中的"-"清除
                char[] ch = scanner.next().replace("-", "").toCharArray();
                // 逐字符处理
                for (int j = 0; j < ch.length; j++) {
                    if (j == 3) {
                        sb.append("-");
                    }
                    // 是否为字母
                    if (Character.isLetter(ch[j])) {
                        // 添加对应的数字字母
                        sb.append(map[1].charAt(map[0].indexOf(ch[j])));
                    } else {
                        // 数字直接添加
                        sb.append(ch[j]);
                    }
                }
                // 将转换好的字符串添加到set中
                set.add(sb.toString());
                // 将sb置空，重新利用
                sb.delete(0, sb.length());
            }

            for (String s:set) {
                System.out.println(s);
            }
            System.out.println();

        }

    }

}
