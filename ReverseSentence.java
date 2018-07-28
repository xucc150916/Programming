/**
 * 字符串单词翻转
 *
 * Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 注意的坑：
 *      最后一个单词后面不能有空格，需要在最后单独删除
 *      谨防全是空格的字符串，这种情况也要单独处理
 */

public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.reverseSentence("world. hello"));
    }

    public String reverseSentence(String str) {
        // 非法输入
        if (str==null || str.length()==0) {
            return str;
        }
        // 全是空格
        if(str.trim().equals("")){
            return str;
        }

        String[] arr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}
