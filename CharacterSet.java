import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个字符串，求出该字符串包含的字符集合
 */

public class CharacterSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            Set<String> set = new HashSet<>();
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                String tmp = str.substring(i, i+1);
                // 当前元素在set中不重复则add返回true
                if (set.add(tmp)) {
                    result.append(tmp);
                }
            }
            System.out.println(result.toString());
        }
        scanner.close();
    }



}
