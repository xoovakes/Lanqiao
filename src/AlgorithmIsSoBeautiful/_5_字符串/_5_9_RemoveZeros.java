package AlgorithmIsSoBeautiful._5_字符串;

import org.assertj.core.api.Assertions;

/**
 * _5_9_RemoveZeros
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/18 下午 10:40
 */
public class _5_9_RemoveZeros {
    public static void main(String[] args) {
        String s1 = "A0000B00";
        String s2 = "A0B00";
        Assertions.assertThat(new _5_9_RemoveZeros().remove1(s1, 3)).isEqualTo(s2);
    }

    public String remove1(String iniString, int k) {
        char[] arr = iniString.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '0') {
                count++;
            } else {
                for (int j = 0; j < count % k; j++) {
                    sb.append('0');
                }
                sb.append(c);
                count = 0;
            }
        }
        for (int j = 0; j < count % k; j++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public String remove(String iniString, int k) {
        //正则表达式
        String regexp = "0{" + k + "}";
        return iniString.replaceAll(regexp, "");
    }
}
