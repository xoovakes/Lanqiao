package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_5_Zipper
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/17 下午 3:18
 */
public class _5_5_Zipper {
    public static void main(String[] args) {
        System.out.println(new _5_5_Zipper().zipString("abbbbbbbbc"));
    }

    private String zipString(String str) {
        int count = 0;
        char last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (sb.length() == 0) {
                sb.append(charAt);
                count++;
            } else {
                if (last == charAt) {
                    count++;
                } else {
                    sb.append(count).append(charAt);
                    count = 1;
                }
            }
            last = charAt;
        }
        if (count >= 1) {
            sb.append(count);
        }
        if (sb.length() >= str.length()) {
            return str;
        }
        return sb.toString();
    }
}
