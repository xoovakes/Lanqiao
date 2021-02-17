package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_2_ReverseString
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/17 下午 3:17
 */
public class _5_2_ReverseString {
    public static void main(String[] args) {
        String str = "abcdeFGHJ";
        String str2 = new _5_2_ReverseString().reverseString(str);
        System.out.println(str2);
    }

    public String reverseString1(String str) {
        char[] charArr = new char[str.length()];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = str.charAt(str.length() - 1 - i);
        }
        return new String(charArr);
    }

    public String reverseString(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}
