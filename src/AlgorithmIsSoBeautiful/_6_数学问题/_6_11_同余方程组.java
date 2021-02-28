package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_11_同余方程组
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 下午 5:18
 */
public class _6_11_同余方程组 {
    public static void main(String[] args) {
        //余数
        long[] a = {2, 3, 2};
        //模
        long[] m = {3, 5, 7};
        long res = 0;
        try {
            res = ExtGcd.linearEquationGroup(a, m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    private static class ExtGcd {
        static long x, y;

        /**
         * x = a1(%m1)
         * = a2(%m2)
         * = a3(%m3)
         * x = a1+m1y1 (1)
         * x = a2+m2y2
         * ==> m1y1 - m2y2 = a2-a1 这是一个线性方程，
         */
        public static long linearEquationGroup(long[] a, long[] m) throws Exception {
            int len = a.length;
            if (len == 0 || a[0] == 0) {
                return m[0];
            }

            for (int i = 1; i < len; i++) {
                long a2_a1 = a[i] - a[i - 1];
                long d = linearEquation(m[i - 1], -m[i], a2_a1);
                //现在的x是y1，用y1求得一个特解
                long x0 = a[i - 1] + m[i - 1] * x;
                long lcm = m[i - 1] * m[i] / d;
                a[i] = (x0 % lcm + lcm) % lcm;
                m[i] = lcm;
            }
            //合并完之后，只有一个方程：x = a[len-1] (% m[len-1])
            return a[len - 1] % m[len - 1];
        }

        /**
         * 求逆元
         * ax = 1 (% mo), gcd(a,mo) = 1
         * ax + m0*y = 1
         */
        public static long inverseElement(long a, long m0) throws Exception {
            long d = linearEquation(a, m0, 1);
            x = (x % m0 + m0) % m0;
            return d;
        }

        /**
         * 裴蜀(贝祖)等式
         * 递推关系(x,y是上一层，x1,y1是下一个状态)
         * x = y1
         * y = x1 - a/b*y1
         */
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

        /**
         * 线性方程
         * ax+by=m, 当m=gcd(a,b)倍数时有解
         * 等价于ax=m mod b
         */
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
