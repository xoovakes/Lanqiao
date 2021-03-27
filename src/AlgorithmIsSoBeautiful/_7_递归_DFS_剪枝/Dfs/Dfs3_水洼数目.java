package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

import java.util.Scanner;

/**
 * Dfs3_水洼数目
 * 输入:
 * 10 12
 * W........WW.
 * .WWW.....WWW
 * ....WW...WW.
 * .........WW.
 * .........W..
 * ..W......W..
 * .W.W.....WW.
 * W.W.W.....W.
 * .W.W......W.
 * ..W.......W.
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/09 上午 12:52
 */
public class Dfs3_水洼数目 {
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 感觉代码的思路是没问题的，但是报错了：Index 0 out of bounds for length 0
                // 全局变量的问题
                if (a[i][j] == 'W') {
                    dfs(a, i, j); //清除一个水洼
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(char[][] a, int i, int j) {
        // 检查过的 W 消掉
        a[i][j] = '.';
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                // 八个方向检查，(0,0)是中间不用检查
                // -1,-1 / -1,0 / -1,1
                if (k == 0 && l == 0) {
                    continue;
                }
                if (i + k >= 0 && i + k <= n - 1 && j + l >= 0 && j + l <= m - 1) {
                    if (a[i + k][j + l] == 'W') {
                        dfs(a, i + k, j + l);
                        //W直接就消掉了，不需要保留状态，不需要回溯
                    }
                }
            }
        }
    }
}
