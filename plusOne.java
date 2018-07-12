/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * 使用一个数组表示一个整数，数字最高位在数组开头，给这个数字加1，使用该数组表示结果
 */

public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] arr = plusOne.plusOne(new int[] {
                9
        });
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        boolean carryFlag = false;
        // 加1操作
        digits[index] += 1;
        for(int i = index; i >= 0; i--) {
            // 处理前一位传来的进位
            if(carryFlag) {
                digits[i]++;
                carryFlag = false;
            }

            // 设置当前为进位标志
            if(digits[i] == 10) {
                carryFlag = true;
            }

            // 当前位满，变成0
            if(digits[i] == 10) {
                digits[i] = 0;
            }
        }
        // carryFlag出循环后还未true，证明最高位存在进位
        if(carryFlag==true) {
            int[] newDigitals = new int[index+2];
            newDigitals[0] = 1;
            for(int i = 1; i < index+2; i++) {
                newDigitals[i] = digits[i-1];
            }
            return newDigitals;
        }
        return digits;
    }

}
