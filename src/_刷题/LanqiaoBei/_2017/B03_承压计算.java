package _刷题.LanqiaoBei._2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B03_承压计算
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 12:32
 */
public class B03_承压计算 {
    static double[][] arr = new double[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    arr[i][j] += arr[i - 1][j] * 1.0 / 2;
                else
                    arr[i][j] += arr[i - 1][j] * 1.0 / 2 + arr[i - 1][j - 1] * 1.0 / 2;
            }
        }
        Arrays.sort(arr[29]);
        long res = (long) (2086458231 / arr[29][0] * arr[29][29]);
        System.out.println(res);
    }
}
