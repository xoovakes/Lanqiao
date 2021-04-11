package _刷题.LanqiaoBei._2017;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * A07_正则问题
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=464
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/11 下午 4:53
 */
public class A07_正则问题 {
    static String s;
    static int len;
    static int pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        len = s.length();
        int ans = f();
        System.out.println(ans);
    }

    private static int f() {
        int m = 0;
        int tmp = 0;
        while (pos < len) {
            if (s.charAt(pos) == '(') {
                pos++;
                tmp += f();
            } else if (s.charAt(pos) == 'x') {
                pos++;
                tmp++;
            } else if (s.charAt(pos) == '|') {
                pos++;
                m = max(m, tmp);
                tmp = 0;
            } else if (s.charAt(pos) == ')') {
                pos++;
                m = max(m, tmp);
                return m;
            }
        }
        m = max(m, tmp);
        return m;
    }
}
