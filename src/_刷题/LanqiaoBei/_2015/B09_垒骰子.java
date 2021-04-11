package _刷题.LanqiaoBei._2015;

import java.util.Scanner;

/**
 * https://www.dotcpp.com/oj/problem2261.html
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=289
 * 用矩阵来快速幂运算最快
 */

public class B09_垒骰子 {
    static int[] op = new int[7];
    static int n, m;
    private static final long mod = 1000000000 + 7;

    static void init() {
        op[1] = 4;
        op[2] = 5;
        op[3] = 6;
        op[4] = 1;
        op[5] = 2;
        op[6] = 3;
    }

    public static void main(String[] args) {
        init();
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        long conflict[][] = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                conflict[i][j] = 1;
            }
        }
        //建立冲突矩阵
        for (int i = 0; i < m; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            conflict[op[x] - 1][y - 1] = 0;
            conflict[op[y] - 1][x - 1] = 0;
        }
        //求冲突矩阵的n-1次方
        long[][] mPow_n_1 = mPow(conflict, n - 1);
        //累加mPow_n_1矩阵
        long ans = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                ans = (ans + mPow_n_1[i][j]) % mod;
            }
        }
        System.out.println(ans * quick_Pow(4, n) % mod);
    }

    //求i的n次方快速幂
    private static long quick_Pow(long i, int n) {
        long ret = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ret = (ret * i) % mod;
            }
            i = (i * i) % mod;
            n >>= 1;
        }
        return ret;
    }

    /*
     * 矩阵的快速幂
     */
    private static long[][] mPow(long[][] conflict, int n) {
        long[][] ans = new long[6][6];

        //单位矩阵：对角线为1 其余皆为0
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = 0;
                }

            }

        }
        while (n != 0) {
            if ((n & 1) == 1) {//该位上为1 ans矩阵与conflict矩阵相乘
                ans = mMul(ans, conflict);
            }
            conflict = mMul(conflict, conflict);
            //n右移一位 除以2
            n >>= 1;
        }
        return ans;

    }

    //矩阵乘法
    private static long[][] mMul(long[][] a, long[][] b) {
        long[][] ans = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return ans;
    }

}
