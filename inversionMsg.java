import java.util.Scanner;

// 将一句话的单词进行倒置，标点不进行倒置
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        System.out.println(inversionMsg(msg));
        sc.close();
    }


    public static String inversionMsg(String msg) {
        // 用空格将字符串分开
		String[] vocabulary = msg.split(" ");
		int len = vocabulary.length;
		StringBuffer result = new StringBuffer(len);
		for(int i = vocabulary.length-1; i > 0; i--) {
			result.append(vocabulary[i]+" ");
		}
		result.append(vocabulary[0]);
        return result.toString();
	}

}
