package AlgorithmIsSoBeautiful._7_递归_DFS_剪枝.Dfs;

import java.util.Scanner;

/**
 * Dfs1_数独
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/05 下午 7:19
 */
public class Dfs1_数独 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < table.length; i++) {
            table[i] = sc.nextLine().toCharArray();
        }
        solve(table, 0, 0);
    }

    private static void solve(char[][] table, int x, int y) {
        if (x == 9) {
            print(table);
            System.exit(0);
        }
        if (table[x][y] == '0') {
            for (int k = 1; k < 10; k++) {
                if (check(table, x, y, k)) {
                    table[x][y] = (char) ('0' + k);
                    //处理下一个状态
                    solve(table, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            //回溯
            table[x][y] = '0';
        } else {
            //处理下一个状态
            solve(table, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) {
                return false;
            }
            if (table[l][j] == (char) ('0' + k)) {
                return false;
            }
        }
        //检查小九宫格
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) {
                    return false;
                }
            }
        }
        return true;
    }

    //打印列表
    private static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }
}
