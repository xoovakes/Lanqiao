package _刷题.LanqiaoBei._2016;

/**
 * B07_剪邮票
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=389
 * https://blog.csdn.net/kavu1/article/details/51130029
 * 答案: 116
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/06 下午 6:34
 */
public class B07_剪邮票 {
    static int a[] = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
    static int ans;
    static boolean vis[] = new boolean[12];

    public static void main(String[] args) {
        int path[] = new int[12];
        f(0, path);
        System.out.println(ans);
    }

    private static void f(int k, int[] path) {
        if (k == 12) {
            if (check(path)) {
                ans++;
            }
        }
        for (int i = 0; i < 12; i++) {
            if (i > 0 && a[i] == a[i - 1] && !vis[i - 1])
                continue;
            if (!vis[i]) {
                vis[i] = true;
                path[k] = a[i];
                f(k + 1, path);
                vis[i] = false;
            }
        }
    }

    private static boolean check(int[] path) {
        int[][] g = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (path[i * 4 + j] == 1)
                    g[i][j] = 1;
                else
                    g[i][j] = 0;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (g[i][j] == 1) {
                    dfs(g, i, j);
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }

    private static void dfs(int[][] g, int i, int j) {
        g[i][j] = 0;
        if (i - 1 >= 0 && g[i - 1][j] == 1) dfs(g, i - 1, j);
        if (i + 1 <= 2 && g[i + 1][j] == 1) dfs(g, i + 1, j);
        if (j - 1 >= 0 && g[i][j - 1] == 1) dfs(g, i, j - 1);
        if (j + 1 <= 3 && g[i][j + 1] == 1) dfs(g, i, j + 1);
    }
}
