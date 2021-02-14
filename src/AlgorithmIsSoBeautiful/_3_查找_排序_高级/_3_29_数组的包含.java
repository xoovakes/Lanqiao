package AlgorithmIsSoBeautiful._3_查找_排序_高级;

import java.util.Arrays;

/**
 * _3_29_数组的包含
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/14 下午 9:19
 */
public class _3_29_数组的包含 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcxyz";
        boolean b = new _3_29_数组的包含().check1(s1, s2);
        System.out.println(b);
        b = new _3_29_数组的包含().check2(s1, s2);
        System.out.println(b);
    }

    public boolean check1(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if (s2.indexOf(a) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean check2(String s1, String s2) {
        char[] s2_arr = s2.toCharArray();
        Arrays.sort(s2_arr);
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            int index = Arrays.binarySearch(s2_arr, a);
            if (index < 0) {
                return false;
            }
        }
        return true;
    }
}
