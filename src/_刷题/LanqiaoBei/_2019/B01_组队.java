/*
 * input:
 1 97 90 0 0 0
 2 92 85 96 0 0
 3 0 0 0 0 93
 4 0 0 0 80 86
 5 89 83 97 0 0
 6 82 86 0 0 0
 7 0 0 0 87 90
 8 0 97 96 0 0
 9 0 0 89 0 0
 10 95 99 0 0 0
 11 0 0 96 97 0
 12 0 0 0 93 98
 13 94 91  0 0 0
 14 0 83 87 0 0
 15 0 0 98 97 98
 16 0 0 0 93 86
 17 98 83 99 98 81
 18 93 87 92 96 98
 19 0 0 0 89 92
 20 0 99 96 95 81  +
 */

package _刷题.LanqiaoBei._2019;

import java.util.Scanner;

/**
 * B01_组队
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/16 下午 2:31
 */

public class B01_组队 {
    private static int ans;
    private static int[] d = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] teams = new int[21][6];
        for (int i = 1; i < teams.length; i++) {
            for (int j = 0; j < teams[i].length; j++) {
                teams[i][j] = sc.nextInt();
            }
        }
        ans = 0;
        dfs(teams, 1, 0);
        System.out.println(ans);
//        System.out.println(Arrays.toString(d));//t
    }

    private static void dfs(int[][] teams, int j, int sum) {
        if (j == 6) {
            if (ans < sum) {
//                System.out.println(Arrays.toString(d) + " " + ans);//t
                ans = sum;
            }
            return;
        }
        int[] rem = new int[6];
        for (int i = 1; i < teams.length; i++) {
            int key = teams[i][j];
            if (key == 0) continue;
            for (int k = 0; k < teams[i].length; k++) {
                rem[k] = teams[i][k];
                teams[i][k] = 0;
            }
            dfs(teams, j + 1, sum + key);
            for (int k = 0; k < teams[i].length; k++) {
                teams[i][k] = rem[k];
            }
        }
    }
}
