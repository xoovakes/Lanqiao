package _刷题.LanqiaoBei._2014;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * A09_斐波那契
 * <p>
 * 网站,https://www.dotcpp.com/oj/problem1444.html
 * 现场做的，难度很大
 * 关键点：
 * 1.由定义fib(n) = fib(n+2)-fib(n+1);
 * 2.由1得Σ f(n) = f(n+2) - 1;
 */

public class A09_斐波那契 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, p;
        n = sc.nextLong();
        m = sc.nextLong();
        p = sc.nextLong();
        BigInteger bigP = BigInteger.valueOf(p);
        if (m >= n + 2) {
            //余m没用
            BigInteger ans = fib(n + 2, bigP);
            System.out.println(ans.mod(bigP).longValue() - 1);
        } else {
            BigInteger fibm = fib(m);
            BigInteger ans = fib(n + 2, fibm);
            System.out.println(ans.mod(fibm).mod(bigP).longValue() - 1);
        }
    }

    private static BigInteger fib(long m) {
        BigInteger[][] ans = mPow(m - 2);
        return ans[0][0].add(ans[1][0]);
    }

    private static BigInteger fib(long m, BigInteger mod) {
        BigInteger[][] ans = mPow(m - 2, mod);
        // f(n+2) = f(n) + f(n+1)
        return ans[0][0].add(ans[1][0]);
    }

    private static BigInteger[][] mPow(long n) {
        BigInteger[][] a =
                {
                        {
                                BigInteger.ONE, BigInteger.ONE
                        },
                        {
                                BigInteger.ONE, BigInteger.ZERO
                        }
                };
        // 单位矩阵
        BigInteger[][] ans =
                {
                        {
                                BigInteger.ONE, BigInteger.ZERO
                        },
                        {
                                BigInteger.ZERO, BigInteger.ONE
                        }
                };
        while (n != 0) {
            if ((n & 1) == 1) {
                BigInteger t1 = ans[0][0];
                BigInteger t2 = ans[1][0];
                ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0]));
                ans[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1]));
                ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0]));
                ans[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1]));
            }
            BigInteger t1 = a[0][0];
            BigInteger t2 = a[1][0];
            BigInteger t3 = a[0][1];
            a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0]));
            a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1]));
            a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0]));
            a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1]));
            n >>= 1;
        }
        return ans;
    }

    private static BigInteger[][] mPow(long n, BigInteger mod) {
        BigInteger[][] a =
                {
                        {
                                BigInteger.ONE, BigInteger.ONE
                        },
                        {
                                BigInteger.ONE, BigInteger.ZERO
                        }
                };
        // 单位矩阵
        BigInteger[][] ans =
                {
                        {
                                BigInteger.ONE, BigInteger.ZERO
                        },
                        {
                                BigInteger.ZERO, BigInteger.ONE
                        }
                };
        while (n != 0) {
            if ((n & 1) == 1) {
                BigInteger t1 = ans[0][0];
                BigInteger t2 = ans[1][0];
                ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0])).mod(mod);
                ans[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1])).mod(mod);
                ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0])).mod(mod);
                ans[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1])).mod(mod);
            }
            BigInteger t1 = a[0][0];
            BigInteger t2 = a[1][0];
            BigInteger t3 = a[0][1];
            a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0])).mod(mod);
            a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1])).mod(mod);
            a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0])).mod(mod);
            a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1])).mod(mod);
            n >>= 1;
        }
        return ans;
    }
}
