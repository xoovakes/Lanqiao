package _刷题.LanqiaoBei._2017;

import java.util.Scanner;

/**
 * A10_油漆面积
 * 暴力法
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=470
 * https://blog.csdn.net/qq_39630587/article/details/79758381
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/11 下午 6:03
 */
public class A10_油漆面积 {
    static int n, sum = 0;
    static boolean[][] p = new boolean[10005][10005];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            point(x1, y1, x2, y2);
        }
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                if (p[i][j]) ++sum;
            }
        }
        System.out.println(sum);
    }

    private static void point(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                p[i][j] = true;
            }
        }
    }
}
