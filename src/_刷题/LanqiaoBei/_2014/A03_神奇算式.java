package _刷题.LanqiaoBei._2014;

import java.util.Arrays;

/**
 * A03_神奇算式
 * 枚举
 * 答案：12
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/30 下午 5:43
 */
public class A03_神奇算式 {
    private static int ans;

    public static void main(String[] args) {
        ans = 0;
        f();
        System.out.println(ans);
    }

    private static void f() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j)
                    for (int k = 0; k < 10; k++) {
                        if (k != i && k != j)
                            for (int l = 0; l < 10; l++) {
                                if (l != i && l != j && l != k) {
                                    int src = i * 1000 + j * 100 + k * 10 + l; // 等式右边
                                    int res;
                                    if (j != 0) {
                                        res = i * (j * 100 + k * 10 + l);
                                        check(src, res);
                                    }
                                    if (k != 0) {
                                        res = (i * 10 + j) * (k * 10 + l);
                                        if ((i * 10 + j) < (k * 10 + l))
                                            check(src, res);
                                    }
                                }
                            }
                    }
            }
        }
    }

    private static void check(int src, int res) {
        String s1 = String.valueOf(src);
        String s2 = String.valueOf(res);
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (new String(chars1).equals(new String(chars2))) {
            ans++;
        }
    }
}
