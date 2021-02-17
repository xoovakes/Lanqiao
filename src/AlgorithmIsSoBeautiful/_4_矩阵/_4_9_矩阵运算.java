package AlgorithmIsSoBeautiful._4_矩阵;

import java.util.Scanner;

/**
 * _4_9_矩阵运算
 * 输入:M,N
 * 随后的M行，每行有N个数据(空格隔开),这些是A的数据
 * 随后的M行，每行有N个数据(空格隔开),这些是B的数据
 * 矩阵乘法，AB，A的行乘B的列
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/16 下午 11:20
 */
public class _4_9_矩阵运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //矩阵加法
//        int M = sc.nextInt();
//        int N = sc.nextInt();
//        int[][] A = new int[M][N];
//        int[][] B = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                A[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                B[i][j] = sc.nextInt();
//            }
//        }
//        int[][] X = new _4_9_矩阵运算().getX(A, B);
//        Utils.AboutArray.printTwoDimensionalIntArray(X);
        //矩阵乘法
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] A = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        M = sc.nextInt();
        N = sc.nextInt();
        int[][] B = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        long[][] AB = new _4_9_矩阵运算().getAB(A, B);
        Utils.AboutArray.printTwoDimensionalArray(AB);
    }

    public long[][] getAB(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            //无法访问的语句
            throw new IllegalArgumentException();
        }
        long[][] res = new long[a.length][b[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += (long) a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public int[][] getX(int[][] a, int[][] b) {
        int[][] X = new int[a.length][a[0].length];
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X[0].length; j++) {
                X[i][j] = (b[i][j] - a[i][j]) >> 1;
            }
        }
        return X;
    }

}
