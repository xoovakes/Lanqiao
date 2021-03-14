package AlgorithmIsSoBeautiful._8_贪心_动态规划;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

/**
 * Case02_POJ_1700
 * 1
 * 4
 * 1 2 5 10
 * ---
 * 17
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/11 下午 4:01
 */
public class Case02_POJ_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < speed.length; j++) {
                speed[j] = sc.nextInt();
            }
            Arrays.sort(speed);
            f(n, speed);
        }
    }

    /**
     * speed 得先排好序
     *
     * @param n
     * @param speed
     */
    private static void f(int n, int[] speed) {
        int left = n;
        int ans = 0;
        while (left > 0) {
            if (left == 1) {
                ans += speed[0];
                break;
            } else if (left == 2) {
                ans += speed[1];
                break;
            } else if (left == 3) {
                ans += speed[2] + speed[1] + speed[0];
                break;
            } else {
                //1，2去带：1，2出发，1返回，最后两名出发，2返回
                int s1 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                //1去带：1，3出发，1返回，1,4出发，1返回
                int s2 = speed[left - 1] + speed[left - 2] + 2 * speed[0];
                ans += min(s1, s2);
                left -= 2;
            }
        }
        System.out.println(ans);
    }
}
