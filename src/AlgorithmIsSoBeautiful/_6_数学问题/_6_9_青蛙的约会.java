package AlgorithmIsSoBeautiful._6_数学问题;

import java.util.Scanner;

/**
 * _6_9_青蛙的约会
 * 知识点，求解同余方程
 * // TODO: 21/02/28 有空多看几眼，不是很懂
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 下午 12:18
 */
public class _6_9_青蛙的约会 {
    static long x, y;

    public static long gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long res = gcd(b, a % b);
        long t = x;
        x = y;
        y = t - a / b * y;
        return res;
    }

    public static long linearEquation(long a, long b, long m) throws Exception {
        long d = gcd(a, b);
        //m不是gcd(a,b)的倍数,这个方程无解
        if (m % d != 0) {
            throw new Exception("无解");
        }
        long n = m / d;
        x *= n;
        y *= n;
        return d;
    }

    /**
     * mt + x ≡ nt+ y (mod L)转化为（m - n）t ≡ y - x（mod L）参数 a=m-n b=L m=y-x
     * 即解方程(m-n)k + Lt = y-x
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long m = sc.nextLong();
        long n = sc.nextLong();
        long L = sc.nextLong();
        long d = gcd(m - n, L);
        if ((y1 - x1) % d != 0) {
            System.out.println("Impossible");
        } else {
            //这里融合了线性方程的方法
            x *= (y1 - x1) / d;
            long xi = Math.abs(L / d);
            System.out.println((x % xi + xi) % xi);
        }
    }
}
