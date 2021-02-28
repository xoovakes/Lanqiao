package AlgorithmIsSoBeautiful._6_数学问题;

import static java.lang.Math.abs;

/**
 * _6_7_一步之遥_2
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 下午 12:05
 */
public class _6_7_一步之遥_2 {
    public static void main(String[] args) {
        try {
            ExtGcd.linearEquation(97, -127, 1);
            long x = ExtGcd.x;
            long y = ExtGcd.y;
            System.out.println(abs(x) + abs(y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //私有的静态内部类
    private static class ExtGcd {
        public static long x;
        public static long y;

        public static long ext_gcd(long a, long b) {
            if (b == 0) {
                x = 1;
                y = 0;
                return a;
            }
            long res = ext_gcd(b, a % b);
            //递推,反着递归
            long temp = x;
            x = y;
            y = temp - a / b * y;
            return res;
        }

        public static long linearEquation(long a, long b, long m) throws Exception {
            long d = ext_gcd(a, b);
            //m不是gcd(a,b)的倍数,这个方程无解
            if (m % d != 0) {
                throw new Exception("无解");
            }
            long n = m / d;
            x *= n;
            y *= n;
            return d;
        }

        public static long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }

        public static long gcd(long m, long n) {
            System.out.println(m + " " + n);//test
            return n == 0 ? m : gcd(n, m % n);
        }
    }
}
