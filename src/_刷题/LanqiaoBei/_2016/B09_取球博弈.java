package _刷题.LanqiaoBei._2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B09_取球博弈
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=392
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 12:12
 */
public class B09_取球博弈 {
    private static int[] n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = new int[3];
        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt();
        }
        Arrays.sort(n);
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            char res = f(num, 0, 0);
            System.out.print(res + " ");
        }
        System.out.println();
    }

    static char[][][] cache = new char[1000][2][2];

    /**
     * 参数代表当前取球人面临的局面
     *
     * @param num 球的总数
     * @param me  我方持有的数目-->换成奇偶性
     * @param you 对手持有的数目
     * @return
     */
    private static char f(int num, int me, int you) {
        if (num < n[0]) {
            //不够取，结算
            if ((me & 1) == 1 && (you & 1) == 0) return '+';
            else if ((me & 1) == 0 && (you & 1) == 1) return '-';
            else return '0';
        }
        if (cache[num][me][you] != '\0') return cache[num][me][you];
        boolean ping = false;
        for (int i = 0; i < 3; i++) {
            if (num >= n[i]) {
                char res = f(num - n[i], you, (n[i] & 1) == 0 ? me : (1 - me));
                if (res == '-') {
                    cache[num][me][you] = '+';
                    return '+';
                }
                if (res == '0') {
                    ping = true;
                }
            }
        }
        // 如果能走到这行，说明不存在对手输的情况，那么可能会平局
        if (ping) {
            cache[num][me][you] = '0';
            return '0';
        } else {
            cache[num][me][you] = '-';
            return '-';
        }
    }
}
