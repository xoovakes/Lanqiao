package _刷题._临时放算法作业;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exp2_跳水板
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/10 上午 10:39
 */
public class Exp2_跳水板 {
    static int shorter, longer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        shorter = sc.nextInt();
        longer = sc.nextInt();
        int k = sc.nextInt();
        int[] board = new int[k];
        Arrays.fill(board, shorter);
        int[] rec = new int[k + 1];
        int count = 0;
        rec[count] = shorter * k;
        found(board, rec, count);
    }

    private static void found(int[] board, int[] rec, int count) {
        if (count == board.length) {
            System.out.println(Arrays.toString(rec));
            return;
        }
        board[count] = longer;
        for (int e : board) {
            rec[count + 1] += e;
        }
        found(board, rec, count + 1);
    }
}
