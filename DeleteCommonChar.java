import java.util.Scanner;

/**
 * 删除公共字符
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 */
public class DeleteCommonChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // 这里一定要用nextLine()，因为next()以空格回车制表符为分界符，会丢失数据
            String str1 = scanner.next();
            String str2 = scanner.next();
            char[] arr = new char[str1.length()];
            int index = 0;

            for (int i = 0; i < str1.length(); i++) {
                if (!str2.contains(str1.charAt(i) + "")) {
                    arr[index++] = str1.charAt(i);
                }
            }
            System.out.println(String.valueOf(arr).trim());
        }
    }


}
