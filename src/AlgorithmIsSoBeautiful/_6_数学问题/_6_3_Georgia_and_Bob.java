package AlgorithmIsSoBeautiful._6_数学问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * _6_3_Georgia_and_Bob
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/25 下午 10:51
 */
public class _6_3_Georgia_and_Bob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(deal(arr));
        }
    }

    private static String deal(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        int res = 0;
        //判断奇数
        if ((len & 1) == 1) {
            for (int i = 0; i < len; i += 2) {
                //奇数，0-1一组，2-3一组
                res ^= (i == 0) ? (A[0] - 1) : (A[i] - A[i - 1] - 1);
            }
        } else {
            for (int i = 1; i < len; i += 2) {
                //偶数，1-2一组，3-4一组
                res ^= (A[i] - A[i - 1] - 1);
            }
        }
        if (res == 0) {
            return "Bob will win";
        } else {
            return "Georgia will win";
        }
    }
}
