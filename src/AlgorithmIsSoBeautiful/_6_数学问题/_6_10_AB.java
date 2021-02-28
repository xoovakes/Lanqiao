package AlgorithmIsSoBeautiful._6_数学问题;

import java.util.Scanner;

/**
 * _6_10_AB
 * HDU - 1576
 * 解法:
 * (A/B)%9973,求余，除法不满足交换性，可改为求B关于9973的逆元x，
 * 这样结果等价于Ax%9973等价于x*A%9973等价于xn%9973
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/28 下午 4:05
 */
public class _6_10_AB {
    public static void main(String[] args) {
        int mod = 9973;
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            long n = sc.nextLong();
            long b = sc.nextLong();
            try {
                ExtGcd.inverseElement(b, 9973);
                System.out.println(ExtGcd.x * n % 9973);
            } catch (Exception e) {
                System.out.println("无解");
            }
        }
    }

    private static class ExtGcd {
        static long x, y;

        public static long inverseElement(long a, long m0) throws Exception {
            long d = linearEquation(a, m0, 1);
            x = (x % m0 + m0) % m0;
            return d;
        }

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
