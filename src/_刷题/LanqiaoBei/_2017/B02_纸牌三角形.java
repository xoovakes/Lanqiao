package _刷题.LanqiaoBei._2017;

/**
 * B02_纸牌三角形
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=477
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 12:22
 */
public class B02_纸牌三角形 {
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans / 6);
    }

    private static void f(int k) {
        if (k == 9) {
            int x1 = a[0] + a[1] + a[3] + a[5];
            int x2 = a[0] + a[2] + a[4] + a[8];
            int x3 = a[5] + a[6] + a[7] + a[8];
            if (x1 == x2 && x2 == x3) {
                ans++;
            }
        }
        for (int i = k; i < 9; i++) {
            int t = a[k];
            a[k] = a[i];
            a[i] = t;
            f(k + 1);
            t = a[k];
            a[k] = a[i];
            a[i] = t;
        }
    }
}
