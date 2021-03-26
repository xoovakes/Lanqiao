package AlgorithmIsSoBeautiful._6_数学问题;

/**
 * _6_14_快速幂运算
 *
 * @author zixi
 * @version 1.0
 * @date 21/03/01 下午 11:36
 */
public class _6_14_快速幂运算 {
	public static void main(String[] args) {
		System.out.println(ex2(2, 10));
		for (int i = 1; i < 10; i++) {
			System.out.println(fib(i));
		}
	}

	private static long fib(long n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		long[][] matrix = { { 0, 1 }, { 1, 1 } };
		long[][] res = matrixPower(matrix, n - 1);
		res = matrixMultiply(new long[][] { { 1, 1 } }, res);
		return res[0][0];
	}

	public static long[][] matrixPower(long[][] matrix, long p) {
		// 初始化结果为单位矩阵，对角线为1
		long[][] result = new long[matrix.length][matrix[0].length];
		// 先变成单位矩阵
		for (int i = 0; i < result.length; i++) {
			result[i][i] = 1;
		}
		// 快速幂运算
		long[][] pingFang = matrix;
		while (p != 0) {
			if ((p & 1) != 0) {
				result = matrixMultiply(result, pingFang);
			}
			pingFang = matrixMultiply(pingFang, pingFang);
			p >>= 1;
		}
		return result;
	}

	public static long[][] matrixMultiply(long[][] a, long[][] b) {
		if (a[0].length != b.length) {
			// 无法访问的语句
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

	public static long ex2(long n, long m) {
		long pingFangShu = n; // n的一次方
		long result = 1;
		while (m != 0) {
			// 遇1累乘现在的幂
			if ((m & 1) == 1) {
				result *= pingFangShu;
			}
			// 每移位一次，幂累乘方一次
			pingFangShu = pingFangShu * pingFangShu;
			// 右移一位
			m >>= 1;
		}
		return result;
	}
}
