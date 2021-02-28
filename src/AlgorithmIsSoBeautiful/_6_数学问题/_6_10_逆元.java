package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_10_逆元
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 下午 4:05
 */
public class _6_10_逆元 {
    public static void main(String[] args) {
    }

    /**
     * 求逆元
     * ax = 1 (% mo), gcd(a,mo) = 1
     * ax + m0*y = 1
     */
    public static long inverseElement(long a, long m0) throws Exception {
        long d = ExtGcd.linearEquation(a, m0, 1);
        ExtGcd.x = (ExtGcd.x % m0 + m0) % m0;
        return d;
    }

    private static class ExtGcd {
        static long x, y;

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
    }
}
