package AlgorithmIsSoBeautiful._5_字符串;

/**
 * _5_4_Replacement
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/17 下午 3:18
 */
public class _5_4_Replacement {
    public static void main(String[] args) {
        String str = "Mr John Smith";
        System.out.println(new _5_4_Replacement().replaceSpace(str, 13));
        char[] str1 = "Mr John Smith000000000000000000".toCharArray();
        System.out.println(new _5_4_Replacement().replaceSpace(str1, 13));
    }

    public String replaceSpace(String str, int length) {
        return str.replaceAll("\\s", "%20");
    }

    public String replaceSpace(char[] str, int length) {
        int count = length;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                count += 2;
            }
        }
        int p1 = length - 1;
        int p2 = count - 1;
        while (p1 >= 0) {
            if (str[p1] == ' ') {
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            } else {
                str[p2--] = str[p1];
            }
            p1--;
        }
        return new String(str, 0, count);
    }
}
