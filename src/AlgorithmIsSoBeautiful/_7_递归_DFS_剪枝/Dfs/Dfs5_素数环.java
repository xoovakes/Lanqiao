package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

import java.util.Scanner;

/**
 * Dfs5_素数环
 * 输入正整数n，对1到n进行排列，使得相邻两个数之和均为素数，
 * 输出时从整数1开始，逆时针排列。同一个环应恰好输出一次。
 * ---
 * 输入：6
 * 输出：
 * 1 4 3 2 5 6
 * 1 6 5 2 3 4
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/09 下午 6:13
 */
public class Dfs5_素数环 {
    static int n;
    static int[] rec;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rec = new int[n];
        rec[0] = 1;
        dfs(1);
    }

    private static void dfs(int cur) {
        //isP(rec[0] + rec[n - 1]), 判断首尾相加是否为素数
        if (cur == n && isP(rec[0] + rec[n - 1])) {
            print(rec);
            return;
        }
        for (int i = 2; i <= n; i++) {
            // 试, i行不行
            if (check(rec, i, cur)) {
                rec[cur] = i;
                dfs(cur + 1);
                // 回溯
                rec[cur] = 0;
            }
        }
    }

    // 检查
    private static boolean check(int[] rec, int i, int cur) {
        for (int e : rec) {
            if (e == i || !isP(rec[cur - 1] + i)) {
                return false;
            }
        }
        return true;
    }

    // 是否为素数
    private static boolean isP(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 打印
    private static void print(int[] rec) {
        for (int i = 0; i < rec.length; i++) {
            System.out.print(rec[i] + (i == rec.length - 1 ? "" : " "));
        }
        System.out.println();
    }


}
