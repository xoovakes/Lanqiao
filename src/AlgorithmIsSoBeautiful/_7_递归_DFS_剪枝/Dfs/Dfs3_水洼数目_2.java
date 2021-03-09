package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

import java.util.Scanner;

/**
 * Dfs3_水洼数目_2
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/09 下午 1:39
 */
public class Dfs3_水洼数目_2 {
    private static void dfs(char[][] a, int i, int j) {
        a[i][j] = '.';//发现后清除水
        //8个方向的套路
        for (int k = -1; k < 2; k++) {//-1 0 1
            for (int l = -1; l < 2; l++) {//-1 0 1
                if (k == 0 && l == 0) {//原地不动
                    continue;
                }
                if (i + k >= 0 && i + k < a.length && j + l >= 0 && j + l < a[0].length) {//i+k为0-M-1 j+l为0-N-1
                    if (a[i + k][j + l] == 'W')//如果8个方向中有水，朝着有水的方向递归，再标记为无水
                        dfs(a, i + k, j + l);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char[][] a = new char[M][N];
        for (int i = 0; i < M; i++) {
            a[i] = sc.next().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < M; i++) {//8个方向的套路
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 'W') {//找到第一个水洼
                    dfs(a, i, j);//执行回来回来，清除了一片区域
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
