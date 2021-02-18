package AlgorithmIsSoBeautiful._5_字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * _5_6_字符集相同
 * check1限制为ascii
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/17 下午 3:19
 */
public class _5_6_字符集相同 {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "cbafefcbaefaeb";
        System.out.println(new _5_6_字符集相同().check1(s1, s2));
        System.out.println(new _5_6_字符集相同().check2(s1, s2));
    }

    private boolean check2(String s1, String s2) {
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.putIfAbsent(c, true);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.get(c)==null) {
                return false;
            }
        }
        return true;
    }

    private boolean check1(String s1, String s2) {
        boolean[] help = new boolean[256];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!help[c]) {
                help[c] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!help[c]) {
                return false;
            }
        }
        return true;
    }
}
