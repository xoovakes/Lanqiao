package _刷题.LanqiaoBei._2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * B08_四平方数
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=391
 *
 * @author zixi
 * @version 1.0
 * @date 21/04/07 下午 12:11
 */
public class B08_四平方数 {
    static int N;
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int c = 0; c * c <= N / 2; ++c) {
            for (int d = c; c * c + d * d <= N; ++d) {
                cache.putIfAbsent(c * c + d * d, c);
            }
        }
        for (int a = 0; a <= N / 4; ++a) {
            for (int b = a; b <= N / 2; ++b) {
                if (cache.get(N - a * a - b * b) != null) {
                    int c = cache.get(N - a * a - b * b);
                    int d = (int) sqrt(N - a * a - b * b - c * c);
                    System.out.println(a+" "+b+" "+c+" "+d);
                    return;
                }
            }
        }
    }
}
