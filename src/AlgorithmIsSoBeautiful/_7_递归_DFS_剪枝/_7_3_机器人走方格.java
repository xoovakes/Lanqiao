package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝;

import java.util.Scanner;

/**
 * _7_3_机器人走方格
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/02 下午 5:56
 */
public class _7_3_机器人走方格 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("返回: " + countWays(x, y));
        System.out.println("返回: " + countWays2(x, y));
    }

    private static int countWays2(int x, int y) {
        int[][] a = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            a[i][1] = 1;
        }
        for (int i = 1; i <= y; i++) {
            a[1][i] = 1;
        }
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[x][y];
    }

    private static int countWays(int x, int y) {
        if (x == 1 || y == 1) return 1;
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
