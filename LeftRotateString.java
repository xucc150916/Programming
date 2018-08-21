/**
 * 将所给字符串的所有空格替换为%20
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace replace = new ReplaceSpace();
        System.out.println(new ReplaceSpace().replaceSpace("asdf asdf", 9));
    }

    public String replaceSpace(String iniString, int length) {
        if (iniString == null || length < 1) {
            return iniString;
        }

        return iniString.replaceAll(" ", "%20");
    }
}
