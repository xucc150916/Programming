// 不调用库函数，将一个数字字符串返回为数字，不符合的返回0，可以输入空字符串
public class Test {
	public static void main(String[] args) {

		System.out.println(StrToInt(""));

	}
	
	public static int StrToInt(String str) {
        char[] data = str.toCharArray();
		int num = 0;
		boolean flag = true;

		// 空字符串
		if(data.length == 0) {
			return 0;
		}
        if(data.length == 1) {
        	// 数值为0
        	if(data[0] == '0') {
        		return 0;
        	} else if(isNumber(data[0])){
        		return (int)(data[0]-'0');
        	} else {
        		return 0;
        	}
        } else {
        	if(data[0] == '+') {
        		flag = true;
        	} else if(data[0]== '-'){
        		flag = false;
        	} else {
        		for(int i = 0; i < data.length; i++) {
            		if(isNumber(data[i])) {
            			num = num*10+(int)(data[i]-'0');
            		} else {// 不是数字，直接返回0
            			return 0;
            		}
            	}
        		return num;
        	}
        	
        	for(int i = 1; i < data.length; i++) {
        		if(isNumber(data[i])) {
        			num = num*10+(int)(data[i]-'0');
        		} else {// 不是数字，直接返回0
        			return 0;
        		}
        	}
        	if(flag) {
        		return num;
        	} else {
        		return -num;
        	}
        	
        }
    }
	
	public static boolean isNumber(char num) {
		if(num<'0' || num>'9') {
			return false;
		} else {
			return true;
		}
	}
}