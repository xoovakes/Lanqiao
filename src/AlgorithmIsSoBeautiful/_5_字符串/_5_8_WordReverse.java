package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_8_WordReverse
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 10:24
 */
public class _5_8_WordReverse {
    public static void main(String[] args) {
        String str = "are you OK";
        System.out.println(new _5_8_WordReverse().reverse(str));
    }
    public String reverse(String str){
        _5_2_ReverseString c = new _5_2_ReverseString();
        String s1 = c.reverseString(str);
        String[] words = s1.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(c.reverseString(word)).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
