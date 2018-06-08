// 给定字符串A，和它的长度n，以及下标p，返回旋转之后的结果
public class Test {

	public static void main(String[] args) {
		System.out.println(rotateString("ABCDEFGH", 8, 4));
	}
	
    public static String rotateString(String A, int n, int p) {
        StringBuffer sbuf = new StringBuffer(A);
        sbuf.append(A);
        return sbuf.substring(p+1, n+p+1).toString();
    }

}