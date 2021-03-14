package AlgorithmIsSoBeautiful._8_贪心_动态规划._背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Case07_最优装载问题
 * 给定n个物体，第i个物体重量为wi。选择尽量多的物体，使得总重量不超过C。
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/14 下午 2:36
 */
public class Case07_最优装载问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
        }
        int C = sc.nextInt();
        Arrays.sort(w);
        int ans = f(w, C);
        System.out.println(ans);
    }

    private static int f(int[] w, int c) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            if (sum <= c) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
