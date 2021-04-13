package _刷题.LanqiaoBei._2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B06_递增三元组
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/13 下午 11:25
 */
public class B06_递增三元组 {
    private static int N, ans;
    private static int[] a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N];
        b = new int[N];
        c = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        for (int i = 0; i < N; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(c);

        ans = 0;
        for (int i = 0; i < a.length; i++) {
            int j1 = getIndex(b, a[i]);
//            System.out.println("1 " + j1);
            for (int j = j1; j < b.length; j++) {
                int k1 = getIndex(c, b[j]);
//                System.out.println("2 " + k1);
                for (int k = k1; k < c.length; k++) {
                    System.out.printf("%d %d %d", a[i], b[j], c[k]);
                    System.out.println();
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }
    /*
4
1 2 3 4
1 2 4 8
4 1 6 8
 */

    private static int getIndex(int[] arr, int key) {
        int res = Arrays.binarySearch(arr, key);
        if (res >= 0) {
            res = Arrays.binarySearch(arr, key + 1);
        }
        if (res < 0) {
            res = -res - 1;
        }
        return res;
    }
}